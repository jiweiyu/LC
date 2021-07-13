package leetcode;

public class BestTimeToBuyAndSellStockII_122 {

    public int maxProfit_(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return T_ik0;
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i+1]>prices[i]){
                res += prices[i+1]-prices[i];
            }
        }
        return res;
    }
}
