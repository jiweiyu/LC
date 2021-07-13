package leetcode;

public class MaximumAverageSubarrayII_644 {

    public double findMaxAverage(int[] nums, int k) {
        double l = -10001, r = 10001;
        while(l + 0.00001 < r) {
            double m = l + (r - l) / 2;
            if (canFindLargerAverage(nums, k, m)) {
                l = m;
            }
            else {
                r = m;
            }
        }
        return l;
    }

    private boolean canFindLargerAverage(int[] nums, int k, double x) {
        int n = nums.length;
        double[] a = new double[n];
        for (int i = 0; i < n; i++) {
            a[i] = nums[i] - x;
        }
        double cur = 0, prev = 0;
        for (int i = 0; i < k; i++) {
            cur += a[i];
        }
        if (cur >= 0) {
            return true;
        }
        for (int i = k; i < n; i++) {
            cur += a[i];
            prev += a[i - k];
            if (prev < 0) {
                cur -= prev;
                prev = 0;
            }
            if (cur >= 0) {
                return true;
            }
        }
        return false;
    }
}
