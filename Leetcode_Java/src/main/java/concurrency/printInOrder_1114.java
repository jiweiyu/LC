package concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;


//https://leetcode.com/problems/print-in-order/discuss/893827/Java-SynchronizedLockSemaphoreCondition-Variable

public class printInOrder_1114 {

    private final AtomicInteger firstJobDone = new AtomicInteger(0);
    private final AtomicInteger secondJobDone = new AtomicInteger(0);

    //public printInOrder_1114(){}

    public void first(Runnable printFirst) throws InterruptedException{
        printFirst.run();
        firstJobDone.incrementAndGet();
    }
    private Object lock;
//    private boolean oneDone;
//    private boolean twoDone;
//
//    public Foo() {
//        lock = new Object();
//        oneDone = false;
//        twoDone = false;
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        synchronized (lock) {
//            printFirst.run();
//            oneDone = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        synchronized (lock) {
//            while (!oneDone) {
//                lock.wait();
//            }
//            printSecond.run();
//            twoDone = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        synchronized (lock) {
//            while (!twoDone) {
//                lock.wait();
//            }
//            printThird.run();
//        }
//    }

    public void second(Runnable printSecond) throws InterruptedException{
        while(firstJobDone.get()!=1){
            //waiting for the first job done
        }

        printSecond.run();
        secondJobDone.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException{
        while(secondJobDone.get()!=1){
            //waiting for the second job done
        }

        printThird.run();
    }

    //semaphore

    Semaphore run2, run3;

    public printInOrder_1114(){
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first_(Runnable printFirst) throws InterruptedException{
        printFirst.run();
        run2.release();
    }

    public void second_(Runnable printSecond) throws InterruptedException{
        run2.acquire();
        printSecond.run();
        run3.release();
    }

    public void third_(Runnable printThird) throws InterruptedException{
        run3.acquire();
        printThird.run();
    }

    //sync method

//    private boolean oneDone;
//    private boolean twoDone;
//
//    public Foo() {
//        oneDone = false;
//        twoDone = false;
//    }
//
//    public synchronized void first(Runnable printFirst) throws InterruptedException {
//        printFirst.run();
//        oneDone = true;
//        notifyAll();
//    }
//
//    public synchronized void second(Runnable printSecond) throws InterruptedException {
//        while (!oneDone) {
//            wait();
//        }
//        printSecond.run();
//        twoDone = true;
//        notifyAll();
//    }
//
//    public synchronized void third(Runnable printThird) throws InterruptedException {
//        while (!twoDone) {
//            wait();
//        }
//        printThird.run();
//    }

    //sync object

//    private Object lock;
//    private boolean oneDone;
//    private boolean twoDone;
//
//    public Foo() {
//        lock = new Object();
//        oneDone = false;
//        twoDone = false;
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        synchronized (lock) {
//            printFirst.run();
//            oneDone = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        synchronized (lock) {
//            while (!oneDone) {
//                lock.wait();
//            }
//            printSecond.run();
//            twoDone = true;
//            lock.notifyAll();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        synchronized (lock) {
//            while (!twoDone) {
//                lock.wait();
//            }
//            printThird.run();
//        }
//    }

    //condition race
//    private Lock lock;
//    private boolean oneDone;
//    private boolean twoDone;
//    private Condition one;
//    private Condition two;
//
//    public Foo() {
//        lock = new ReentrantLock();
//        one = lock.newCondition();
//        two = lock.newCondition();
//        oneDone = false;
//        twoDone = false;
//    }
//
//    public void first(Runnable printFirst) throws InterruptedException {
//        lock.lock();
//        try {
//            printFirst.run();
//            oneDone = true;
//            one.signal();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void second(Runnable printSecond) throws InterruptedException {
//        lock.lock();
//        try {
//            while (!oneDone) {
//                one.await();
//            }
//            printSecond.run();
//            twoDone = true;
//            two.signal();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    public void third(Runnable printThird) throws InterruptedException {
//        lock.lock();
//        try {
//            while (!twoDone) {
//                two.await();
//            }
//            printThird.run();
//        } finally {
//            lock.unlock();
//        }
//    }


}
