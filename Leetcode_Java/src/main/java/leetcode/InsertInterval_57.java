package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {

    public int[][] insert(int[][] intervals, int[] newSpan) {
        List<int[]> result = new ArrayList<>();
        int index = 0;
        // Add all non-overlapping intervals before the 'newSpan'
        while (index < intervals.length && intervals[index][1] < newSpan[0]) {
            result.add(intervals[index++]);
        }
        // Merge all overlapping intervals into the newSpan
        while (index < intervals.length && intervals[index][0] <= newSpan[1]) {
            int[] thisSpan = intervals[index++];
            newSpan[0] = Math.min(thisSpan[0], newSpan[0]);
            newSpan[1] = Math.max(thisSpan[1], newSpan[1]);

        }
        result.add(newSpan);  // return the merged newspan

        // Add all remaining non-overlapping intervals after the merged newSpan
        while (index < intervals.length) {
            result.add(intervals[index++]);
        }

        return result.toArray(new int[result.size()][]);
    }

}
