package leetcode;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget_1300 {

    public int findBestValue_1(int[] A, int target) {
        Arrays.sort(A);
        int n = A.length, i = 0;
        while (i < n && target > A[i] * (n - i)) {
            target -= A[i++];
        }
        if (i == n) return A[n - 1];
        int res = target / (n - i);
        if (target - res * (n - i) > (res + 1) * (n - i) - target)
            res++;
        return res;
    }

    public int findBestValue_2(int[] arr, int target) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int a : arr) {
            sum += a;
            max = Math.max(max, a);
        }
        if (sum == target) return max;
        int min = 0, res = 1,diff = Integer.MAX_VALUE;
        // The answer would lie between 0 and maximum value in the array.
        while (min <= max) {
            int mid = min + (max - min) / 2;
            sum = getMutatedSum(arr, mid);
            if (sum > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            // If current difference is less than diff || current difference==diff but mid < res.(choose the smaller one.)
            if (Math.abs(sum - target) < diff || (Math.abs(sum - target) == diff && mid < res)) {
                res = mid;
                diff = Math.abs(sum - target);
            }
        }
        return res;
    }

    private int getMutatedSum(int[] arr, int mid) {
        int sum = 0;
        for (int a : arr) {
            sum += (a > mid) ? mid : a;
        }
        return sum;
    }
}
