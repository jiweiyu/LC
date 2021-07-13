package microsoft;


/*
其中问到我design pattern用过哪些，我说factory / singleton，然后就立刻让我写一个factory pattern的code，并且跑出结果。

A singleton pattern ensures that you always get back the same instance of whatever type you are retrieving, whereas the factory pattern generally gives you a different instance of each type.

The purpose of the singleton is where you want all calls to go through the same instance. An example of this might be a class that manages a disk cache, or gets data from a static dictionary; wherever it is important only one known instance interacts with the resource. This does make it less scalable.

The purpose of the factory is to create and return new instances. Often, these won't actually be the same type at all, but they will be implementations of the same base class. However, there may be many instances of each type

 */
public class DesignPattern {


//
//    //singleton
//    //1, Eager initialization
////    Pros:
////    Very simple to implement.
////    Cons:
////    May lead to resource wastage. Because instance of class is created always, whether it is required or not.
////    CPU time is also wasted in creation of instance if it is not required.
////    Exception handling is not possible.
//    public class GFG{
//        private static final GFG instance = new GFG();
//        private GFG(){
//
//        }
//        public static GFG getInstance(){
//            return instance;
//        }
//    }
//
//    //2, Useing static block
////    Pros:
////
////    Very simple to implement.
////    No need to implement getInstance() method. Instance can be accessed directly.
////    Exceptions can be handled in static block.
////            Cons:
////
////    May lead to resource wastage. Because instance of class is created always, whether it is required or not.
////    CPU time is also wasted in creation of instance if it is not required.
//    public class GFG{
//        public static GFG instance;
//        private GFG(){
//
//        }
//        {
//            instance = new GFG();
//        }
//    }
//
//    //3, lazy initialization
////
////    Pros:
////
////    Object is created only if it is needed. It may overcome resource overcome and wastage of CPU time.
////    Exception handling is also possible in method.
////            Cons:
////
////    Every time a condition of null has to be checked.
////    instance can’t be accessed directly.
////    In multithreaded environment, it may break singleton property.
//    public class GFG{
//        private static GFG instance;
//
//        private GFG(){
//
//        }
//
//        public static GFG getInstance(){
//            if(instance == null){
//                instance = new GFG();
//            }
//            return instance;
//        }
//    }
//
//    //4, Thread safe singleton
////    Pros:
////
////    Lazy initialization is possible.
////    It is also thread safe.
////            Cons:
////
////    getInstance() method is synchronized so it causes slow performance as multiple threads can’t access it simultaneously.
////
//    public class GFG{
//        private static GFG instance;
//        private GFG(){
//        }
//
//        synchronized public static GFG getInstance(){
//            if(instance == null){
//                instance = new GFG();
//            }
//            return instance;
//        }
//    }
//
//    //5, lazy initialization with double check locking
////    Pros:
////
////    Lazy initialization is possible.
////    It is also thread safe.
////    Performance overhead gets reduced because of synchronized keyword.
////            Cons:
////
////    First time, it can affect performance.
////    As cons. of double check locking method is bearable so it can be used for high performance multi-threaded applications.
//    public class GFG{
//        private static GFG instance;
//        private GFG(){
//
//        }
//        public static GFG getInstance(){
//            if(instance == null){
//                synchronized (GFG.class){
//                    if(instance == null){
//                        instance = new GFG();
//                    }
//                }
//            }
//            return instance;
//        }
//    }
//
//    //6, bill push singleton implementation
//    public class GFG{
//
//        private GFG(){
//
//        }
//
//        private static class BillPushSingleton{
//            private static final GFG INSTANCE = new GFG();
//        }
//        public static GFG getInstance(){
//            return BillPushSingleton.INSTANCE;
//        }
//    }
//
//
//    //factory method
//    //In Factory pattern, we create object without exposing the creation logic to the client
//    // and refer to newly created object using a common interface.
//
//    //step 1, interface
//    public interface Shape{
//        void view();
//    }
//
//    //step 2, create concrete classes implementing the same interface
//    public class Rectangle implements Shape{
//
//        @Override
//        public void draw(){
//            System.out.println("Inside Square::draw() method.");
//        }
//    }
//
//    public class Circle implements Shape {
//
//        @Override
//        public void draw() {
//            System.out.println("Inside Circle::draw() method.");
//        }
//    }
//
//    //step 3, create factory to generate object of concrete class based on given information
//    public class ShapeFactory{
//        public Shape getShape(String shapeType){
//            if(shapeType == null){
//                return null;
//            }
//            if(shapeType.equalsIgnoreCase("CIRCLE")){
//                return new Circle();
//            }
//            if(shapeType.equalsIgnoreCase("RECTANGLE")){
//                return new Circle();
//            }
//            if(shapeType.equalsIgnoreCase("SQUARE")){
//                return new Circle();
//            }
//            return null;
//        }
//    }
//
//    //step 4, use the Factory to get object of concrete class by passing type
//    public class FactoryPatternDemo {
//
//        public static void main(String[] args) {
//            ShapeFactory shapeFactory = new ShapeFactory();
//
//            //get an object of Circle and call its draw method.
//            Shape shape1 = shapeFactory.getShape("CIRCLE");
//
//            //call draw method of Circle
//            shape1.draw();
//
//            //get an object of Rectangle and call its draw method.
//            Shape shape2 = shapeFactory.getShape("RECTANGLE");
//
//            //call draw method of Rectangle
//            shape2.draw();
//
//            //get an object of Square and call its draw method.
//            Shape shape3 = shapeFactory.getShape("SQUARE");
//
//            //call draw method of square
//            shape3.draw();
//        }
//    }
}
