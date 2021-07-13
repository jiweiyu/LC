package microsoft;

/*
general cases for all best time to buy and sell stock problems
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/discuss/108870/Most-consistent-ways-of-dealing-with-the-series-of-stock-problems

 */

public class BestTimeToBuyAndSellStockwithTrasactionFee_714 {

    public int maxProfit_withfee_1(int[] prices, int fee){
       long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

       for(int price: prices){
           long T_ik0_old = T_ik0;
           T_ik0 = Math.max(T_ik0, T_ik1 + price - fee);
           T_ik1 = Math.max(T_ik1, T_ik0_old - price);
       }
       return (int)T_ik0;
    }

    public int maxProfit_withfee_2(int[] prices, int fee){
        long T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for(int price: prices){
            long T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price - fee);
        }
        return (int)T_ik0;
    }
}
