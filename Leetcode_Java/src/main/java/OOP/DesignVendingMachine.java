package OOP;

import java.util.*;

public class DesignVendingMachine {
    /*
     * kind of Pair class
     */
    public class Bucket<E1, E2>{
        private E1 first;
        private E2 second;

        public Bucket(E1 first, E2 second){
            this.first = first;
            this.second = second;
        }

        public E1 getFirst(){
            return first;
        }

        public E2 getSecond(){
            return second;
        }
    }

    /*
     * Java Enum to represent Coins supported by vending machine
     */
    public enum Coin{
        PENNY(1), NICKLE(5), DIME(10), QUARTER(25);
        private int denomination;
        private Coin(int denomination){
            this.denomination = denomination;
        }
        public int getDenomination(){
            return denomination;
        }
    }

    /*
    * Enum to represent Item served by Vending machine
     */
    public enum Item{
        COKE(0, "Coke", 315), PEPSI(1, "Pepsi", 315), SODA(2, "Soda", 300);
        private final int id;
        private final String name;
        private final int price;
        private Item(int id, String name, int price){
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public int getPrice() {
            return price;
        }
    }

    /*
    Inventory inside vending machin
     */
    public class Inventory<T>{
        private Map<T, Integer> inventory = new HashMap<T, Integer>();

        public int getQuantity(T item){
            Integer value = this.inventory.get(item);
            return value == null ? 0 : value;
        }
        public void add(T item){
            int count = this.inventory.get(item);
            inventory.put(item, count+1);
        }
        public void deduct(T item){
            if(hasItem(item)){
                int count = this.inventory.get(item);
                this.inventory.put(item, count - 1);
            }
        }
        public boolean hasItem(T item){
            return getQuantity(item) > 0;
        }
        public void clear(){
            this.inventory.clear();
        }
        public void put(T item, int quantity){
            this.inventory.put(item, quantity);
        }
    }

    /*
    interface for vending machine
     */
    public interface VendingMachine{
        long selectItemAndGetPrice(Item item) throws SoldOutException;
        void insertCoin(Coin coin);
        List<Coin> refund() throws NoSufficientChangeException;
        Bucket<Item, List<Coin>> collectItemAndChange() throws NoSufficientChangeException, NotFullPaidException;
        void reset();
    }


    //check exception, not runtime exception
    //Checked Exception is required to be handled by compile time while unchecked Exception doesn't
    //Checked Exception sub class of Exception , represent scenario with higher failure rate
    //Unchecked Exception sub class of RuntimeException, mostly programming mistakes

    //Checked Exception requirs mandatory try catch or try finally block
    //Unchecked Exception don't
    public class SoldOutException extends Exception{
        private static final long serialVersionUID = -2853385181394137730L;
        public SoldOutException(String message){
            super(message);
        }
    }

    public class NoSufficientChangeException extends Exception{
        private static final long serialVersionUID = -2853385181394137739L;
        public NoSufficientChangeException(String message){
            super(message);
        }
    }

    public class NotFullPaidException extends Exception{
        private static final long serialVersionUID = 5396842421321007235L;
        private long remaining;
        public NotFullPaidException(String message, long remaining){
            super(message);
            this.remaining = remaining;
        }
        public long getRemaining(){
            return remaining;
        }
        @Override
        public String getMessage(){
            return super.getMessage() + remaining;
        }
    }

    /*
    A Factory class to create different kinds of Vending Machine
     */
    public  class VendingMachineFactory{
        public  VendingMachine createVendingMachine(){
            return new VendingMachineImpl();
        }
    }

    public  class VendingMachineImpl implements VendingMachine{
        private Inventory<Coin> cashInventory = new Inventory<>();
        private Inventory<Item> itemInventory = new Inventory<>();
        private long totalSales;
        private Item currentItem;
        private long currentBalance;

        public VendingMachineImpl(){
            initialize();
        }

        private void initialize(){
            for(Coin c : Coin.values()){
                this.cashInventory.put(c, 5);
            }
            for(Item i : Item.values()){
                this.itemInventory.put(i, 5);
            }
        }

        @Override
        public long selectItemAndGetPrice(Item item) throws SoldOutException{
            if(this.itemInventory.hasItem(item)){
                this.currentItem = item;
                return currentItem.getPrice();
            }
            throw new SoldOutException("Sold Out, Please buy another item");
        }

        @Override
        public void insertCoin(Coin coin){
            this.currentBalance += coin.getDenomination();
            this.cashInventory.add(coin);
        }

        @Override
        public Bucket<Item, List<Coin>> collectItemAndChange() throws NoSufficientChangeException, NotFullPaidException {
            Item item = collectItem();
            this.totalSales += this.currentItem.getPrice();

            List<Coin> change = collectChange();
            return new Bucket<Item, List<Coin>>(item, change);
        }

        private Item collectItem() throws NoSufficientChangeException, NotFullPaidException{
            if(isFullPaid()){
                if(hasSuffientChange()){
                    this.itemInventory.deduct(currentItem);
                    return this.currentItem;
                }
                throw new NoSufficientChangeException("No Sufficient change in Inventory");
            }
            long remainingBalance = this.currentItem.getPrice() - this.currentBalance;
            throw new NotFullPaidException("Price not full paid, remaining: ", remainingBalance);
        }

        private List<Coin> collectChange() throws NoSufficientChangeException{
            long changeAmount = currentBalance - currentItem.getPrice();
            List<Coin> change = getChange(changeAmount);
            updateCashInventory(change);
            currentBalance = 0;
            currentItem = null;
            return change;
        }

        @Override
        public List<Coin> refund() throws NoSufficientChangeException{
            List<Coin> refund = getChange(currentBalance);
            updateCashInventory(refund);
            currentBalance = 0;
            currentItem = null;
            return refund;
        }

        private boolean isFullPaid(){
            return this.currentBalance >= this.currentItem.getPrice();
        }

        private List<Coin> getChange(Long amount) throws NoSufficientChangeException{
            if(amount <= 0){
                return Collections.emptyList();
            }
            List<Coin> changes = new ArrayList<>();
            long balance = amount;
            while(balance > 0){
                if(balance >= Coin.QUARTER.getDenomination() && this.cashInventory.hasItem(Coin.QUARTER)){
                    changes.add(Coin.QUARTER);
                    balance -= Coin.QUARTER.getDenomination();
                }else if(balance >= Coin.DIME.getDenomination() && this.cashInventory.hasItem(Coin.DIME)){
                    changes.add(Coin.DIME);
                    balance -= Coin.DIME.getDenomination();
                }else if(balance >= Coin.NICKLE.getDenomination() && this.cashInventory.hasItem(Coin.NICKLE)){
                    changes.add(Coin.NICKLE);
                    balance -= Coin.NICKLE.getDenomination();
                }else if(balance >= Coin.PENNY.getDenomination() && this.cashInventory.hasItem(Coin.PENNY)){
                    changes.add(Coin.PENNY);
                    balance -= Coin.PENNY.getDenomination();
                }else{
                    throw new NoSufficientChangeException("No sufficient change, please try another product");
                }
            }
            return changes;
        }

        @Override
        public void reset(){
            this.cashInventory.clear();
            this.itemInventory.clear();
            this.totalSales = 0;
            this.currentItem = null;
            this.currentBalance = 0;
        }

        public void printStats(){
            System.out.println("Total sales: " + this.totalSales);
            System.out.println("Current Item Inventory: " + this.itemInventory);
            System.out.println("Current Cash Inventory: " + this.cashInventory);
        }

        private boolean hasSuffientChange(){
            return hasSuffientChangeForAmount(this.currentBalance - this.currentItem.getPrice());
        }

        private boolean hasSuffientChangeForAmount(long amount){
            try{
                getChange(amount);
                return true;
            }catch(NoSufficientChangeException ex){
                return false;
            }
        }

        private void updateCashInventory(List<Coin> change){
            for(Coin c : change){
                this.cashInventory.deduct(c);
            }
        }

        private long getTotalSales(){
            return this.totalSales;
        }
    }


}
