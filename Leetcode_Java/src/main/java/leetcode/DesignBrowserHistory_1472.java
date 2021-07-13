package leetcode;

import java.util.Stack;

public class DesignBrowserHistory_1472 {


    Stack<String> history = new Stack<String>();
    Stack<String> forward = new Stack<String>();
    String cur;

    public DesignBrowserHistory_1472(String homepage) {
        cur = homepage;
    }

    public void visit(String url) {
        forward = new Stack<>();
        history.push(cur);
        cur = url;
    }

    public String back(int steps) {
        while(!history.isEmpty() && --steps >= 0){
            forward.push(cur);
            cur = history.peek();
            history.pop();
        }
        return cur;
    }

    public String forward(int steps) {
        while(!forward.isEmpty() && --steps >= 0){
            history.push(cur);
            cur = forward.peek();
            forward.pop();
        }
        return cur;
    }
}
