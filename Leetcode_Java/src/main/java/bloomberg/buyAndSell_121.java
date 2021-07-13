package bloomberg;

/**
 * Created by yujiwei on 18/7/5.
 */
public class buyAndSell_121 {


    //O(n)
    public int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }
        int lowest = prices[0];
        int profit = 0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<lowest){
                lowest = prices[i];
            }
            if(profit<(prices[i]-lowest)){
                profit = prices[i] - lowest;
            }
        }

        return profit;
    }
}
