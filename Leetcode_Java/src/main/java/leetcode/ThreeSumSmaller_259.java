package leetcode;

import java.util.Arrays;

public class ThreeSumSmaller_259 {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i<n-2;i++){
            int j = i+1, k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum>=target){
                    k--;
                }else{
                    res+=k-j;
                    j++;
                }
            }
        }
        return res;
    }
}
