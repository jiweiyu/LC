package leetcode;

public class LongestPalindromicSubsequence_516 {


    public int longestPalindromeSubseq_1(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int i = s.length()-1; i>=0; i--){
            dp[i][i] = 1;
            for(int j = i +1; j<s.length();j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] +2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }

    //top bottom recursive method with memoization
    public int longestPalindromeSubseq_2(String s) {
        return helper(s, 0, s.length()-1, new Integer[s.length()][s.length()]);
    }

    private int helper(String s, int i, int j, Integer[][] memo){
        if(memo[i][j] != null){
            return memo[i][j];
        }
        if(i>j) return 0;
        if(i == j) return 1;
        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = helper(s, i+1, j-1, memo) + 2;
        }else{
            memo[i][j] = Math.max(helper(s, i+1, j, memo), helper(s, i, j -1, memo));
        }
        return memo[i][j];
    }
}
