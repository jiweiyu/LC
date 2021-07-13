package leetcode;

public class MinimumCostForTickets_983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[30];
        int d = 0;
        int lastday = days[days.length-1];

        for(int i = days[0]; i <= lastday; i++){
            if(i != days[d]){
                dp[i%30] = dp[(i-1)%30];
            }else{
                dp[i%30] = Math.min(dp[(i-1)%30] + costs[0],
                        Math.min(dp[Math.max(i-7, 0)%30] + costs[1],
                        dp[Math.max(i-30, 0)%30] + costs[2]));
                d++;
            }
        }
        return dp[lastday%30];
    }

    public int mincostTickets_2(int[] days, int[] costs) {
        boolean[] dayIncluded = new boolean[366];
        for (int day : days) {
            dayIncluded[day] = true;
        }
        int[] minCost = new int[366];
        minCost[0] = 0;
        for (int day = 1; day <= 365; ++day) {
            if (!dayIncluded[day]) {
                minCost[day] = minCost[day-1];
                continue;
            }
            int min;
            min = minCost[day-1] + costs[0];
            min = Math.min(min, minCost[Math.max(0, day-7)] + costs[1]);
            min = Math.min(min, minCost[Math.max(0, day-30)] + costs[2]);
            minCost[day] = min;
        }

        return minCost[365];

    }
}
