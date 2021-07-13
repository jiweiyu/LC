package leetcode;

public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int T_i0 = 0, T_i1 = Integer.MIN_VALUE;
        for(int p : prices){
            T_i0 = Math.max(T_i0, T_i1+p);
            T_i1 = Math.max(T_i1, -p);
        }
        return T_i0;
    }
}
