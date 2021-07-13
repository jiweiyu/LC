package OOP;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.*;

public class DesignRestaurant {

    public static enum State{
        CREATED, SUBMITTED, PROCESSING, CANCELLED, COMPLETED;
    }

    public class User implements OrderStateChangeEventListener{
        private int id;
        private String name;
        private String phone;
        private String address;
        public User(int id, String name, String phone, String address){
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.address = address;
        }

        @Override
        public void notify(Order order, Order.State oldState, Order.State newState, Object... details) {

        }
    }

    public class Restaurant implements OrderStateChangeEventListener{
        private int id;
        private String name;
        private String phone;
        private String address;
        private String email;
        private List<Menu> menus;
        private final BlockingQueue<Order> queue;

        public Restaurant(int id, String name, String phone, String address, String email, List<Menu> menus){
            this.id = id;
            this.name = name;
            this.phone = phone;
            this.address = address;
            this.email = email;
            this.menus = menus;
            this.queue = new LinkedBlockingDeque<>();

            new Thread(()->{
                while(true){
                    try{
                        Order order = this.queue.take(); //blockingqueue, wait while queue is empty
                        order = OrderProcessor.getInstance().handle(order);
                        order = OrderDispatcher.getInstance().handle(order);
                    }catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }


        @Override
        public void notify(Order order, Order.State oldState, Order.State newState, Object... details) {

        }


    }

    public class Menu{
        private int id;
        private Restaurant restaurant;
        private List<Item> items;

        public Menu(int id, List<Item> items){
            this(id, null, items);
        }
        public Menu(int id, Restaurant restaurant, List<Item> items){
            this.id = id;
            this.restaurant = restaurant;
            this.items = items;
        }
    }

    public class Item{
        private final int id;
        private String name;
        private double price;

        public Item(int id, String name, double price){
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public  class ItemBuilder{
            private final int id;
            private String name;
            private double price;

            public ItemBuilder(int id){
                this.id = id;
            }

            public ItemBuilder withName(String name) {
                this.name = name;
                return this;
            }

            public ItemBuilder withPrice(double price) {
                this.price = price;
                return this;
            }

            public Item build(){
                return new Item(this.id, this.name, this.price);
            }
        }
    }

    //mimic database sequence generation
//    public class IdGenerator{
//        private static AtomicInteger generator = new AtomicInteger();
//        public static int generateId(){
//            return generator.incrementAndGet();
//        }
//    }

    public interface OrderStateChangeEventListener{
        void notify(Order order, Order.State oldState, Order.State newState, Object... details);
    }

    public static class Order{
        private final int id;
        private final Restaurant restaurant;
        private Map<Item, Integer> items;
        private double total;
        private final User user;
        private State state;
        private List<OrderStateChangeEventListener> listeners;

        public static enum State{
            CREATED, SUBMITTED, PROCESSING, CANCELLED, COMPLETED;
        }

        public Order(int id, Restaurant restaurant, User user){
            this.id = id;
            this.restaurant = restaurant;
            this.user = user;
            this.total = 0;
            this.listeners = new ArrayList<>();
        }

        public State getState(){
            return state;
        }

        public void setState(State state){
            this.state = state;
        }

        public User  getUser(){
            return user;
        }
    }

    public interface OrderHandler{
        Order handle(Order order);
    }

    public class OrderCreator implements OrderHandler{
        private static OrderCreator instance = new OrderCreator();
        private OrderCreator(){};

        @Override
        public Order handle(Order order){
            order.addStateChangeListeners(order.getRestaurant(), order.getUser());
            order.setState(Order.State.CREATED); //db commit
            order.notifyStateChangeListeners(null, Order.State.CREATED);
            return order;
        }

        public static OrderCreator getInstance(){
            return instance;
        }
    }

    public class OrderSubmitter implements OrderHandler{
        private static OrderSubmitter instance = new OrderSubmitter();
        private OrderSubmitter(){};

        @Override
        public Order handle(Order order){
            order.setState(Order.State.SUBMITTED); //db commit
            try{
                order.getRestaurant().getQueue().put(order);
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            return order;
        }

        public static OrderSubmitter getInstance(){
            return instance;
        }
    }

    public class OrderProcessor implements OrderHandler{
        private static OrderProcessor instance = new OrderProcessor();
        private OrderProcessor(){};

        @Override
        public Order handle(Order order){
            order.setState(Order.State.PROCESSING);
            order.notifyStateChangeListeners(Order.State.CREATED, Order.State.PROCESSING);
            return order;
        }

        public static OrderProcessor getInstance(){
            return instance;
        }
    }

    public class OrderDispatcher implements OrderHandler{
        private static OrderDispatcher instance = new OrderDispatcher();
        private OrderDispatcher(){};

        @Override
        public Order handle(Order order){
            order.setState(Order.State.COMPLETED);
            order.notifyStateChangeListeners(Order.State.PROCESSING, Order.State.COMPLETED);
            return order;
        }

        public static OrderDispatcher getInstance(){
            return instance;
        }
    }

    //Worker and Dispatcher to multi thread

    public class OrderProcessorMultipleWorkers implements OrderHandler, AutoCloseable{

        private final ExecutorService executor;

        public OrderProcessorMultipleWorkers(int workers){
            this.executor = Executors.newFixedThreadPool(workers);
        }

        @Override
        public Order handle(Order order){
            this.executor.submit(()->{
                order.setState(Order.State.PROCESSING);
                order.notifyStateChangeListeners(Order.State.CREATED, Order.State.PROCESSING);
                try{
                    Thread.sleep(1000); //simulating processing
                }catch(InterruptedException e){

                }
                order.setState(Order.State.PROCESSED); //adding a new state here PROCESSED
                System.out.println("Order " + order + " processed");
            }
            );
            return order;
        }

        @Override
        public void close() throws Exception{
            this.executor.shutdown();
        }
    }

    public class OrderDispatcherMultipleWorkers implements OrderHandler{
        private final ExecutorService executor;
        private final BlockingQueue<Runnable> buffer;

        public OrderDispatcherMultipleWorkers(int workers, int bufferSize){
            this.buffer = new ArrayBlockingQueue<>(bufferSize);
            this.executor = new ThreadPoolExecutor(workers, workers + bufferSize, 1, TimeUnit.HOURS, this.buffer);
        }

        @Override
        public Order handle(Order order){

            this.executor.submit(()->{
                try{
                    Thread.sleep(1000); //simulating processing
                }catch(InterruptedException e){

                }
                order.setState(Order.State.COMPLETED);
                order.notifyStateChangeListeners(Order.State.PROCESSED, Order.State.COMPLETED);
                System.out.println("Order " + order + " processed");
            }
            );
            return order;
        }
    }


}
