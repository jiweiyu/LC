package leetcode;

public class MaxDotProductOfTwoSubsequences_1458 {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;

        int[][] dp = new int[l1][l2];
        for(int i = 0; i < l1; i++){
            for(int j = 0; j < l2; j++){
                dp[i][j] = nums1[i]*nums2[j];
                if(i>0 && j>0) dp[i][j] += Math.max(0, dp[i-1][j-1]);
                if(i>0)dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if(j>0)dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
            }
        }
        return dp[l1-1][l2-1];
    }
}
