package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class LongestValidParentheses_32 {

    public int longestValidParentheses_stack(String s){
        LinkedList<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' && stack.size()>1 && s.charAt(stack.peek())=='('){
                stack.pop();
                result = Math.max(result,i-stack.peek());
            }else{
                stack.push(i);
            }
        }
        return result;
    }

    public int longestValidParentheses_dp(String s){
        int[] dp = new int[s.length()];
        int result = 0;
        int leftCount = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                leftCount++;
            }else if(leftCount>0){
                dp[i] = dp[i-1]+2;
                dp[i] += (i-dp[i])>= 0 ? dp[i-dp[i]] : 0;
                result = Math.max(result, dp[i]);
                leftCount--;
            }
        }
        return result;
    }

}
