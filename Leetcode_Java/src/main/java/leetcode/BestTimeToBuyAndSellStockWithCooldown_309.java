package leetcode;

public class BestTimeToBuyAndSellStockWithCooldown_309 {
    public int maxProfit(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for(int p : prices){
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + p);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - p);
            T_ik0_pre = T_ik0_old;
        }
        return T_ik0;
    }
}
