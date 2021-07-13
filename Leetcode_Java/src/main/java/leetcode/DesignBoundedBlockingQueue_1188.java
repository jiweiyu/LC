package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.*;

public class DesignBoundedBlockingQueue_1188 {

    Deque<Integer> deq;
    int size;
    Object lock;
    public DesignBoundedBlockingQueue_1188(int capacity) {
        deq = new LinkedList<>();
        size = capacity;
        lock = new Object();
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized(lock) {
            while(deq.size() == size) {
                lock.wait();
            }
            deq.addLast(element);
            lock.notify();
        }
    }

    public int dequeue() throws InterruptedException {
        int val = 0;
        synchronized(lock) {
            while(deq.isEmpty()) {
                lock.wait();
            }
            val = deq.removeFirst();
            lock.notify();
        }
        return val;
    }

    public int size() {
        return deq.size();
    }

    //synchroized
//    private static int capacity;
//    private static List<Integer> q;
//
//    public BoundedBlockingQueue(int capacity) {
//        this.capacity = capacity;
//        q = new ArrayList<>();
//    }
//
//    public synchronized void enqueue(int element) throws InterruptedException {
//
//        while(q.size() >= capacity){
//            wait();
//        }
//
//        if(q.isEmpty()){
//            notifyAll();
//        }
//
//        q.add(0, element);
//
//    }
//
//    public synchronized int dequeue() throws InterruptedException {
//
//        while(q.isEmpty()){
//            wait();
//        }
//
//        if(q.size() == capacity){
//            notifyAll();
//        }
//
//        int res = q.remove(q.size()-1);
//        return res;
//
//
//    }
//
//    public int size() {
//        return q.size();
//    }

}
