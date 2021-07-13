package leetcode;

public class BestTimeToBuyAndSellStockIII_123 {

    //O(n), O(1)
    public int maxProfit(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        int T_i20 = 0, T_i21 = Integer.MIN_VALUE;

        for(int p : prices){
            T_i20 = Math.max(T_i20, T_i21+p);
            T_i21 = Math.max(T_i21, T_i10-p);
            T_i10 = Math.max(T_i10, T_i11+p);
            T_i11 = Math.max(T_i11, -p);
        }
        return T_i20;
    }

}
