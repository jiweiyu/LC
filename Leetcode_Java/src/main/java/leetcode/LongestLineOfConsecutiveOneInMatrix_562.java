package leetcode;

public class LongestLineOfConsecutiveOneInMatrix_562 {


    //O(mn)
    //O(n)
    public int longestLine(int[][] M) {
        int n = M.length, max = 0;
        if (n == 0) return max;
        int m = M[0].length;
        int[][][] dp = new int[n][m][4];
        for (int i=0;i<n;i++)
            for (int j=0;j<m;j++) {
                if (M[i][j] == 0) continue;
                for (int k=0;k<4;k++) dp[i][j][k] = 1;
                if (j > 0) dp[i][j][0] += dp[i][j-1][0]; // horizontal line
                if (j > 0 && i > 0) dp[i][j][1] += dp[i-1][j-1][1]; // anti-diagonal line
                if (i > 0) dp[i][j][2] += dp[i-1][j][2]; // vertical line
                if (j < m-1 && i > 0) dp[i][j][3] += dp[i-1][j+1][3]; // diagonal line
                max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
                max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
            }
        return max;
    }

    //O(mn)
    //O(mn)
    public int longestLine_3D_dp(int[][] M) {
        if (M.length == 0) return 0;
        int ones = 0;
        int[][][] dp = new int[M.length][M[0].length][4];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0 && j < M[0].length - 1) ? dp[i - 1][j + 1][3] + 1 : 1;
                    ones =
                            Math.max(
                                    ones,
                                    Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return ones;
    }
}
