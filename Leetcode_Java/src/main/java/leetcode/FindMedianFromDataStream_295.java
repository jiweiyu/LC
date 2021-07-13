package leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream_295 {

    private final Queue<Long> small = new PriorityQueue<>(Collections.reverseOrder());
    private final Queue<Long> large = new PriorityQueue<>();

    public void addNumber(int num){
        large.add((long) num);
        small.add(large.poll());
        if(large.size()<small.size()){
            large.add(small.poll());
        }
    }

    public double findMedian(){
        return large.size()>small.size() ? large.peek() : (large.peek()+small.peek())/2.0;
    }

    //follow up

    int[] A = new int[100];
    int n = 0;

    public void addNum(int num) {
        A[num]++;
        n++;
    }

    public double findMedian_() {
        int count = 0, i = 0;
        while (count < n/2) count += A[i++];
        int j = i;
        while (count < n/2+1) count += A[j++];
        return (n%2 == 1) ? j-1 : (i+j-2) / 2.0;
    }

}
