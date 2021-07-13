package leetcode;

import java.util.Arrays;

public class ThreeSumClosest_16 {

    public int threeSumClosest(int[] nums, int target) {
        int res = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);

        for(int i = 0; i+2<nums.length;i++){
            int j = i+1, k = nums.length-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<target){
                    j++;
                }else{
                    k--;
                }
                if(Math.abs(target-sum) < Math.abs(target-res)){
                    res = sum;
                }
            }
        }
        return res;
    }

}
