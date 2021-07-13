package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream_346 {

    private final Queue<Integer> q;
    private final int size;
    private double sum = 0;

    /** Initialize your data structure here. */
    public MovingAverageFromDataStream_346(int s) {
        q = new LinkedList<>();
        size = s;
    }

    public double next(int val) {
        if(q.size() == size){
            sum = sum - q.poll();
        }
        q.offer(val);
        sum += val;
        return sum/q.size();
    }
}
