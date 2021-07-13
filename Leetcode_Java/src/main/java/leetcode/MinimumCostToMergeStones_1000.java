package leetcode;

public class MinimumCostToMergeStones_1000 {

    //top down
    int[][][] dp;
    int max = Integer.MAX_VALUE;
    int K;

    public int mergeStones(int[] stones, int K) {
        this.K = K;
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }
        dp = new int[len + 1][len + 1][K + 1];
        int[] prefixSum = new int[len + 1];

        int i;
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        getResult(prefixSum, 1, len, 1);
        return dp[1][len][1];
    }

    private int getResult(int[] prefixSum, int left, int right, int piles) {
        if (dp[left][right][piles] != 0) {
            return dp[left][right][piles];
        }
        int res = max;
        int t;
        if (left == right) {
            res = (piles == 1) ? 0 : max;
        }
        else {
            if (piles == 1) {
                int mergeK = getResult(prefixSum, left, right, K);
                if (mergeK != max) {
                    res = mergeK + prefixSum[right] - prefixSum[left - 1];
                }
            }
            else {
                for (t = left; t < right; t++) {
                    int l = getResult(prefixSum, left, t, piles - 1);
                    int r = getResult(prefixSum, t + 1, right, 1);
                    if (l != max && r != max) {
                        res = Math.min(res, l + r);
                    }
                }
            }
        }
        dp[left][right][piles] = res;
        return res;
    }

    //bottom up
    public int mergeStones_bottomup(int[] stones, int K) {
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }

        int i, j, k, l, t;

        int[] prefixSum = new int[len + 1];
        for (i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        int max = Integer.MAX_VALUE;
        int[][][] dp = new int[len + 1][len + 1][K + 1];
        for (i = 1; i <= len; i++) {
            for (j = 1; j <= len; j++) {
                for (k = 1; k <= K; k++) {
                    dp[i][j][k] = max;
                }
            }
        }

        for (i = 1; i <= len; i++) {
            dp[i][i][1] = 0;
        }

        for (l = 2; l <= len; l++) {
            for (i = 1; i <= len - l + 1; i++) {
                j = i + l - 1;
                for (k = 2; k <= K; k++) {
                    for (t = i; t < j; t++) {
                        if (dp[i][t][k - 1] == max || dp[t + 1][j][1] == max) {
                            continue;
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }
                if (dp[i][j][K] == max) {
                    continue;
                }
                dp[i][j][1] = dp[i][j][K] + prefixSum[j] - prefixSum[i - 1];
            }
        }

        return dp[1][len][1];
    }
}
