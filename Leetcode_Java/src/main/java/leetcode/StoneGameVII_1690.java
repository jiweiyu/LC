package leetcode;

public class StoneGameVII_1690 {

    public int stoneGameVII(int[] stones){
        int n = stones.length;
        int[] prefix = new int[n];
        int[] dp = new int[n];

        for(var i = 0;i < n; i++){
            prefix[i] = stones[i] + (i>0 ? prefix[i-1] : 0);
        }

        for(var i = 0;i< n-1; i++){
            dp[i] = Math.max(stones[i], stones[i+1]);
        }

        for(var l = 2; l < n; l++){
            for(var i = 0;i<n-l;i++){
                dp[i] = Math.max(prefix[i+l-1] - (i>0 ? prefix[i-1] : 0) - dp[i],
                        prefix[i+l] - prefix[i] - dp[i+1]);
            }
        }
        return dp[0];
    }

}
