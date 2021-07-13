package bloomberg;

/**
 * Created by yujiwei on 18/7/5.
 */
public class buyAndSellTwo_122 {

    //O(n)
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
