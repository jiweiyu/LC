package leetcode;

public class MaximumAverageSubarrayI_643 {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        double res = -Double.MIN_VALUE; //positive number
        for(int i=0;i<nums.length-k+1;i++){
            if(i==0){
                for(int j=0;j<k;j++) sum += nums[i+j];
                res = (double) sum/k;
            }else{
                sum = sum - nums[i-1] + nums[i+k-1];
            }
            res = Math.max(res, (double)sum/k);
        }
        return res;
    }
}
