package leetcode;
import java.util.*;
public class MinimumDifficultyOfAJobSchedule_1335 {

    //two dimensional DP
    public int minDifficulty(int[] jobDifficulty, int D){
        final int N = jobDifficulty.length;
        if(N<D) return -1;
        int[][] dp = new int[D][N];
        dp[0][0] = jobDifficulty[0];
        for(int j=1;j<N;j++){
            dp[0][j] = Math.max(jobDifficulty[j],dp[0][j-1]);
        }

        for(int d = 1; d < D; ++d){
            for(int len = d; len < N; ++len){
                int localMax = jobDifficulty[len];
                dp[d][len] = Integer.MAX_VALUE;
                for(int schedule = len; schedule >= d; --schedule){
                    localMax = Math.max(localMax, jobDifficulty[schedule]);
                    dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
                }
            }
        }

        return dp[D - 1][N - 1];
    }

    // one dimensional DP
    public int minDifficulty_(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;

        int[] dp = new int[N + 1];
        for(int i = N - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], jobDifficulty[i]);

        for(int d = 2; d <= D; ++d){
            for(int len = 0; len <= N - d; ++len){
                int max = 0;
                dp[len] = Integer.MAX_VALUE;
                for(int schedule = len; schedule <= N - d; ++schedule){
                    max = Math.max(max, jobDifficulty[schedule]);
                    dp[len] = Math.min(dp[len], max + dp[schedule + 1]);
                }
            }
        }

        return dp[0];
    }

    // one dimensional DP with a monotonic stack
    public int minDifficulty__(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        int[] next = new int[N];
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(int d = 0; d < D; ++d){
            stack.clear();
            for(int len = d; len < N; ++len){
                next[len] = len > 0 ? dp[len - 1] + jobDifficulty[len] : jobDifficulty[len];
                while(!stack.isEmpty() && jobDifficulty[stack.peek()] <= jobDifficulty[len]){
                    int idx = stack.pop();
                    next[len] = Math.min(next[len], next[idx] - jobDifficulty[idx] + jobDifficulty[len]);
                }

                if(!stack.isEmpty()){
                    next[len] = Math.min(next[len], next[stack.peek()]);
                }

                stack.push(len);
            }

            dp = next.clone();
        }

        return dp[N - 1];
    }

    // DFS with memoization
    public int minDifficulty___(int[] jobDifficulty, int D) {
        final int N = jobDifficulty.length;
        if(N < D) return -1;

        int[][] memo = new int[N][D + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return dfs(D, 0, jobDifficulty, memo);
    }

    private int dfs(int d, int len, int[] jobDifficulty, int[][] memo){
        final int N = jobDifficulty.length;
        if(d == 0 && len == N) return 0;
        if(d == 0 || len == N) return Integer.MAX_VALUE;
        if(memo[len][d] != -1) return memo[len][d];

        int curMax = jobDifficulty[len];
        int min = Integer.MAX_VALUE;
        for(int schedule = len; schedule < N; ++schedule){
            curMax = Math.max(curMax, jobDifficulty[schedule]);
            int temp = dfs(d - 1, schedule + 1, jobDifficulty, memo);
            if(temp != Integer.MAX_VALUE)
                min = Math.min(min, temp + curMax);
        }

        return memo[len][d] = min;
    }
}
