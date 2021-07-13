package leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class MinimumSizeSubarraySum_209 {

    public int minSubArrayLen_jiwei(int s, int[] nums) {
        if(nums==null || nums.length==0) return 0;

        int l = 0, r = 0;
        int cur = 0, res = Integer.MAX_VALUE;

        while(r<nums.length){
            cur+=nums[r];
            while(cur>=s){
                res=Math.min(res,r-l+1);
                cur-=nums[l];
                l++;
            }
            r++;
        }
        return res==Integer.MAX_VALUE ? 0:res;
    }


        public int minSubArrayLen(int s, int[] nums) {
            int res = Integer.MAX_VALUE;
            int cur = 0;
            Deque<Integer> deque = new LinkedList<>();
            for(int a : nums){
                cur += a;
                deque.addLast(a);
                while(cur >= s && !deque.isEmpty()){
                    res = Math.min(res, deque.size());
                    int x = deque.peekFirst();
                    cur -= x;
                    deque.pollFirst();
                }
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }

}
