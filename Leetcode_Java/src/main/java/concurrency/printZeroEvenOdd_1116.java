package concurrency;

import java.util.concurrent.*;
public class printZeroEvenOdd_1116 {

    private final int n;
    Semaphore s0 = new Semaphore(1);
    Semaphore s1 = new Semaphore(0);
    Semaphore s2 = new Semaphore(0);


    public printZeroEvenOdd_1116(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
//    public void zero(IntConsumer printNumber) throws InterruptedException {
//        for(int i=1;i<=n;i++){
//            s0.acquire();
//            printNumber.accept(0);
//            if(i%2 == 1) {
//                s1.release();
//            }else{
//                s2.release();
//            }
//        }
//    }
//
//    public void even(IntConsumer printNumber) throws InterruptedException {
//        for(int i=1;i<=n;i++){
//            if(i%2==0){
//                s2.acquire();
//                printNumber.accept(i);
//                s0.release();
//            }
//        }
//    }
//
//    public void odd(IntConsumer printNumber) throws InterruptedException {
//        for(int i=1;i<=n;i++){
//            if(i%2==1){
//                s1.acquire();
//                printNumber.accept(i);
//                s0.release();
//            }
//        }
//
//    }
}
