package leetcode;

import java.util.Arrays;

public class SmallestRangeII_910 {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int res = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(A[i] + K, A[n - 1] - K);
            int min = Math.min(A[i + 1] - K, A[0] + K);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public int smallestRangeII_lee(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length, mx = A[n-1], mn = A[0], res = mx-mn;
        for(int i = 0;i<n-1;i++){
            mx = Math.max(mx, A[i]+2*K);
            mn = Math.min(A[i+1],A[0]+2*K);
            res = Math.min(res, mx-mn);
        }
        return res;
    }

}
