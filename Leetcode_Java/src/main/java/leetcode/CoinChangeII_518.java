package leetcode;

public class CoinChangeII_518 {

    public int change(int amount, int[] coins){
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int coin : coins){
            for(int currAmt = 1; currAmt <= amount;currAmt++){
                if(currAmt >= coin){
                    dp[currAmt] += dp[currAmt-coin];
                }
            }
        }
        return dp[amount];
    }
}
