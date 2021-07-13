package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class RemoveCoveredIntervals_1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]));
        Stack<int[]> res = new Stack<int[]>();
        if (intervals == null || intervals.length == 0) return 0;
        res.push(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.peek()[0] && intervals[i][1] >= res.peek()[1]) {
                res.pop();
                res.push(intervals[i]);
                continue;
            } else if (intervals[i][0] >= res.peek()[0] && intervals[i][1] <= res.peek()[1]) {
                continue;
            } else {
                res.push(intervals[i]);
            }
        }
        return res.size();
    }

    public int removeCoveredIntervals2(int[][] A) {
        int res = 0, right = 0;
        Arrays.sort(A, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] v : A) {
            if (v[1] > right) {
                ++res;
                right = v[1];
            }
        }
        return res;
    }
}
