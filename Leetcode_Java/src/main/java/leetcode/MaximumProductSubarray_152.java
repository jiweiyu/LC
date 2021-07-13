package leetcode;

public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {
        int res = nums[0], n = nums.length, l = 0, r = 0;

        for(int i = 1; i<n; i++){
            l = (l==0? 1:l) * nums[i];
            r = (r==0? 1:r) * nums[n-1-i];
            res = Math.max(res, Math.max(l,r));
        }
        return res;
    }

    public int maxProduct_(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}
