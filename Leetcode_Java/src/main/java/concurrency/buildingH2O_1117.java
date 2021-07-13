package concurrency;

import java.util.concurrent.Semaphore;

public class buildingH2O_1117 {

    private final Object lock = new Object();
    private int counter = 0;
    //public buildingH2O_1117(){}

    public void hydrogen_(Runnable releaseHydrogen) throws InterruptedException{
        synchronized (lock){
            while(counter == 2){
                lock.wait();
            }
            releaseHydrogen.run();
            counter++;
            lock.notifyAll();
        }
    }

    public void oxygen_(Runnable releaseOxygen) throws InterruptedException{
        synchronized (lock){
            while(counter !=2){
                lock.wait();
            }
            releaseOxygen.run();
            counter = 0;
            lock.notifyAll();
        }
    }

    //semaphore

    Semaphore h, o;

    public buildingH2O_1117(){
        h = new Semaphore(2, true);
        o = new Semaphore(0, true);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException{
        h.acquire();
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException{
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }
}
