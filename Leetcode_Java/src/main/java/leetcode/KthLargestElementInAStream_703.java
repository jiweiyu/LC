package leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAStream_703 {

    PriorityQueue<Integer> pq;
    Integer k;
    public KthLargestElementInAStream_703(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        for(int val : nums){
            pq.offer(val);
            if(pq.size() > k) pq.poll();
        }
    }

    public int add(int val) {

        if(pq.size() < k || pq.peek() < val){
            pq.offer(val);
        }

        if(pq.size() > k && val > pq.peek()) {
            pq.poll();
        }
        return pq.peek();
    }
}
