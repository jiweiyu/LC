package concurrency;

import java.util.concurrent.Semaphore;

public class printFooBarAlternately_1115 {

    private final int n;
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(1);

    public printFooBarAlternately_1115(int n){ this.n = n;}

    public void foo(Runnable printFoo) throws InterruptedException{
        for(int i=0;i<n;i++){
            s2.acquire();
            printFoo.run();
            s1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException{
        for(int i=0;i<n;i++){
            s1.acquire();
            printBar.run();
            s2.release();
        }
    }
}
