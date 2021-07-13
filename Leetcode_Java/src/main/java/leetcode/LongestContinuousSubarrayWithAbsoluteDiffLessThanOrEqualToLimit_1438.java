package leetcode;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit_1438 {

    //O(n^2)
    public int longestSubarray(int[] nums, int limit) {
        int start = 0, end = 0, res = 1;
        PriorityQueue<Integer> minQ = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<Integer>(Collections.reverseOrder());

        while(start <= end && end <= nums.length){
            minQ.offer(nums[end]);
            maxQ.offer(nums[end]);
            int minNum = minQ.peek();
            int maxNum = maxQ.peek();
            if(maxNum - minNum <= limit){
                end++;
                res = Math.max(res, end-start);
            }else{
                boolean t = minQ.remove(nums[start]);
                boolean tt = maxQ.remove(nums[start]);
                start++;
                end++;
            }
        }
        return res;
    }

    //O(n)
    public int longestSubarray_Deque(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}
