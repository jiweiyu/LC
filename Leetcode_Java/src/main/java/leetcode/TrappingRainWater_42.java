package leetcode;

import java.util.*;
public class TrappingRainWater_42 {

    public int trap_(int[] height) {
        if(height.length<3) return 0;

        int ans = 0;
        int l = 0, r = height.length-1;

        while(l<r && height[l]<=height[l+1]) l++;
        while(l<r && height[r]<=height[r-1]) r--;

        while(l<r){
            int left = height[l];
            int right = height[r];
            if(left<right){
                while(l<r && left>height[++l]){
                    ans += left-height[l];
                }
            }else{
                while(l<r && height[--r]<=right){
                    ans += right-height[r];
                }
            }
        }
        return ans;
    }

    public int trap(int[] A){
        if(A == null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while(i < A.length){
            if(s.isEmpty() || A[i] <= A[s.peek()]){
                s.push(i++);
            }
            else{
                int bot = s.pop();
                maxBotWater = s.isEmpty() ? 0 : (Math.min(A[s.peek()], A[i]) - A[bot]) * (i-s.peek() - 1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }

}
