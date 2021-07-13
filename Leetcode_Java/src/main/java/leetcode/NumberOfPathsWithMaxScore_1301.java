package leetcode;
import java.util.*;
public class NumberOfPathsWithMaxScore_1301 {

    public int[] pathsWithMaxScore_1(List<String> board) {
        int MOD = (int)(1e9 + 7);
        int m = board.size(), n = board.get(0).length();
        int[][] dp = new int[m+1][n+1];
        int[][] cc = new int[n+1][n+1];
        cc[n-1][n-1] = 1;
        for(int i = m-1;i>=0;i--)
            for(int j = n-1; j>=0;j--){
                char c= board.get(i).charAt(j);
                if(c!='X'){
                    int max = Math.max(Math.max(dp[i+1][j], dp[i][j+1]), dp[i+1][j+1]);
                    int num = c-'0';
                    if(c=='S' || c=='E') num = 0;
                    dp[i][j] = num + max;
                    if(dp[i+1][j] == max) cc[i][j] = (cc[i][j] + cc[i+1][j]) % MOD;
                    if(dp[i+1][j+1] == max) cc[i][j] = (cc[i][j] + cc[i+1][j+1]) % MOD;
                    if(dp[i][j+1] == max) cc[i][j] = (cc[i][j] + cc[i][j+1]) % MOD;
                }
            }

        return cc[0][0] > 0 ? new int[]{dp[0][0], cc[0][0]} : new int[]{0, 0};
    }

    private static final int[][] DIRS = new int[][]{{0, -1}, {-1, 0}, {-1, -1}};
    public int[] pathsWithMaxScore_2(List<String> board) {
        int m = board.size(), n = board.get(0).length();
        int[][] dpSum = new int[m][n];
        int[][] dpCnt = new int[m][n];
        dpCnt[m - 1][n - 1] = 1; // start at the bottom right square
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (dpCnt[r][c] == 0) continue; // can't reach to this square
                for (int[] dir : DIRS) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nc >= 0 && board.get(nr).charAt(nc) != 'X') {
                        int nsum = dpSum[r][c];
                        if (board.get(nr).charAt(nc) != 'E')
                            nsum += board.get(nr).charAt(nc) - '0';
                        if (nsum > dpSum[nr][nc]) {
                            dpCnt[nr][nc] = dpCnt[r][c];
                            dpSum[nr][nc] = nsum;
                        } else if (nsum == dpSum[nr][nc]) {
                            dpCnt[nr][nc] = (dpCnt[nr][nc] + dpCnt[r][c]) % 1000000007;
                        }
                    }
                }
            }
        }
        return new int[]{dpSum[0][0], dpCnt[0][0]};
    }
}
