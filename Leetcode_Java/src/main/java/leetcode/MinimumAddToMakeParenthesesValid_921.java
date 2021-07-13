package leetcode;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid_921 {

    //Time O(N)
    //Space O(1)
    public int minAddToMakeValid_(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') {
                right++;
            } else if (right > 0) {
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }

    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int r = 0, l = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                stack.push(c);
                l++;
            }else{
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                    l--;
                }else{
                    r++;
                }
            }
        }
        return l+r;
    }
}
