package leetcode;

public class MaximumNestingDepthOfTheParentheses_1614 {

    public int maxDepth(String s) {

        int res = 0, depth = 0;
        for(char c : s.toCharArray()){
            if(c=='(') depth++;
            if(c==')') depth--;
            res = Math.max(res, depth);
        }
        return res;
    }
}
