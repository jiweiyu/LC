package leetcode;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_239 {

    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k){
        //remove indexes of elements not from sliding window
        if(!deq.isEmpty() && deq.getFirst() == i-k){
            deq.removeFirst();
        }

        while(!deq.isEmpty() && nums[i] > nums[deq.getLast()]){
            deq.removeLast();
        }
    }


    public int[] maxSlidingWindow_deque(int[] nums, int k) {
        int n = nums.length;
        if(n*k == 0) return new int[0];
        if(k==1) return nums;

        //init deque and output
        this.nums = nums;
        int max_idx = 0;
        for(int i = 0; i<k; i++){
            clean_deque(i, k);
            deq.addLast(i);
            if(nums[i] > nums[max_idx]) max_idx = i;
        }
        int[] output = new int[n-k+1];
        output[0] = nums[max_idx];

        //build output
        for(int i = k; i<n; i++){
            clean_deque(i, k);
            deq.addLast(i);
            output[i-k+1] = nums[deq.getFirst()];
        }
        return output;
    }

    public int[] maxSlidingWindow_dp(int[] nums, int k) {
        int n = nums.length;
        if(n*k == 0) return new int[0];
        if(k==1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n-1] = nums[n-1];
        for(int i = 1; i<n;i++){
            if(i%k == 0) left[i] = nums[i];
            else left[i] = Math.max(left[i-1], nums[i]);

            //right to left
            int j = n-i-1;
            if((j+1)%k == 0) right[j] = nums[j];
            else right[j] = Math.max(right[j+1], nums[j]);
        }

        int[] output = new int[n-k+1];
        for(int i = 0; i<n-k+1; i++){
            output[i] = Math.max(left[i+k-1], right[i]);
        }

        return output;
    }

    public int[] maxSlidingWindow_pq(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b)->(b-a));
        int l = 0, r = 0;
        while(r<k){
            q.offer(nums[r++]);
        }

        while(r<nums.length){
            res[l] = q.peek();
            //System.out.println(res[l]);
            q.offer(nums[r++]);
            q.remove(nums[l++]);
        }
        res[l] = q.peek();
        return res;
    }
}
