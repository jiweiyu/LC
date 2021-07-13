package leetcode;

import java.util.Arrays;
import java.util.TreeSet;

public class TwoSumLessThanK_1099 {

    public int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A); // Time cost O(nlogn).
        int max = -1, i = 0, j = A.length - 1;
        while (i < j) {
            int sum = A[i] + A[j];
            if (sum < K) { // find one candidate.
                max = Math.max(max, sum);
                ++i; // increase the smaller element.
            }else { // >= sum.
                --j; // decrease the bigger element.
            }
        }
        return max;
    }

    public int twoSumLessThanK_(int[] A, int K) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = -1;
        for (int a : A) {
            Integer pre = set.lower(K - a);
            if (pre != null) {
                res = Math.max(res, a + pre);
            }
            set.add(a);
        }
        return res;
    }
}
