package leetcode;

import java.util.*;

public class MinimumNumberOfArrowsToBurstBallons_452 {

    //Time O(NlogN), Space O(1)
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for(int[] p : points){
            xStart = p[0];
            xEnd = p[1];
            if(firstEnd < xStart){
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }
}
