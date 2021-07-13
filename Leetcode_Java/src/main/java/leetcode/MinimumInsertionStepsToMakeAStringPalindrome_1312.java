package leetcode;

public class MinimumInsertionStepsToMakeAStringPalindrome_1312 {

    public int minInsertions_(String s) {
        String sReverse = new StringBuilder(s).reverse().toString();
        int lcs = longestCommonSubsequence(s.toCharArray(), sReverse.toCharArray());
        return s.length() - lcs;
    }

    private int longestCommonSubsequence(char[] arr1, char[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }


    //lee215
    public int minInsertions(String s){
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i+1][j+1] = s.charAt(i)==s.charAt(n-j-1) ? dp[i][j]+1 : Math.max(dp[i][j+1], dp[i+1][j]);
            }
        }
        return n-dp[n][n];
    }
}
