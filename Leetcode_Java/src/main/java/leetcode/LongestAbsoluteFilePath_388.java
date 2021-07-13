package leetcode;
import java.util.Stack;
public class LongestAbsoluteFilePath_388 {

    //some special characters that should be escaped by \ (tab \t, breadline \n, quote \" ...) In Java,
    // so it count as one character and not 2
    public int lengthLongestPath(String input) {
        String[] arr = input.split("\n");
        int res = 0;
        if(arr.length == 0) return res;

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(String a : arr){
            int lev = a.lastIndexOf("\t")+1;

            while(lev+1 < stack.size()){
                stack.pop();
            }
            int len = a.length() + stack.peek() - lev + 1;
            stack.push(len);

            if(a.contains(".")){
                res = Math.max(res, len-1);
            }
        }
        return res;
    }
}
