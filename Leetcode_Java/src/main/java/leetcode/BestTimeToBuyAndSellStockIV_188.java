package leetcode;

import java.util.Arrays;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/most-consistent-ways-of-dealing-with-the-series-of-stock-problems

public class BestTimeToBuyAndSellStockIV_188 {
    public int maxProfit(int k, int[] prices) {
        if(k >= prices.length >>> 1){
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
            for(int p : prices){
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + p);
                T_ik1 = Math.max(T_ik1, T_ik0_old - p);
            }
            return T_ik0;
        }

        int[] T_ik0 = new int[k+1];
        int[] T_ik1 = new int[k+1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);
        for(int p : prices){
            for(int j = k; j > 0; j--){
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + p);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j-1] - p);
            }
        }
        return T_ik0[k];
    }

}
