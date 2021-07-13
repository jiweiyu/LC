package leetcode;

import java.util.Stack;

public class BackspaceStringCompare_844 {
    public boolean backspaceCompare(String S, String T) {
        String a = help(S);
        String b = help(T);
        //System.out.println(a+","+b);
        return a.equals(b);
    }

    private String help(String s){
        Stack<Character> stack = new Stack<>();
        for(char a : s.toCharArray()){
            if(a=='#' && !stack.isEmpty()){
                stack.pop();
                continue;
            }else if(a!='#'){
                stack.push(a);
            }
        }
        return stack.toString();
    }
}
