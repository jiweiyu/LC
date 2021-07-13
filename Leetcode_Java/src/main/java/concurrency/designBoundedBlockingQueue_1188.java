package concurrency;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class designBoundedBlockingQueue_1188 {

    private final Semaphore enq;
    private final Semaphore deq;

    ConcurrentLinkedDeque<Integer> q;

    public designBoundedBlockingQueue_1188(int capacity){
        q = new ConcurrentLinkedDeque<>();
        enq = new Semaphore(capacity);
        deq = new Semaphore(0);
    }

    public void enqueue(int element) throws InterruptedException{
        enq.acquire();
        q.add(element);
        deq.release();
    }

    public int dequeue()throws InterruptedException{
        deq.acquire();
        int val = q.poll();
        enq.release();
        return val;
    }

    public int size(){
        return q.size();
    }


}