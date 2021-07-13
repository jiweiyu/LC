package leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class FinalPricesWithASpecialDiscountInAShop_1475 {

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i<prices.length;i++){
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]){
                 prices[stack.pop()]-= prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
