package leetcode;
import java.util.Stack;
public class OnlineStockSpan_901 {
    Stack<Integer> prices, weights;

    public OnlineStockSpan_901() {
        prices = new Stack();
        weights = new Stack();
    }

    public int next(int price) {
        int w = 1;
        while(!prices.isEmpty() && prices.peek() <= price){
            prices.pop();
            w += weights.pop();
        }
        prices.push(price);
        weights.push(w);
        return w;
    }

}
