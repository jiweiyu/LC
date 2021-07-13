package concurrency;

import java.util.concurrent.Semaphore;

class SemaphoreDemo{
    public static void main(String[] args) throws InterruptedException{
        Semaphore sem = new Semaphore(1);
        semaphoreSample s1 = new semaphoreSample(sem, "A");
        semaphoreSample s2 = new semaphoreSample(sem, "B");

        s1.start();
        s2.start();

        s1.join();
        s2.join();

        System.out.println("count: " + Shared.count);
    }
}
