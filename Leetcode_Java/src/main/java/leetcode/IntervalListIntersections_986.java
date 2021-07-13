package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections_986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int l1 = A.length;
        int l2 = B.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i = 0, j = 0;
        while(i < l1 && j < l2){
            int[] a = A[i];
            int[] b = B[j];
            if(a[1] < b[0]){
                i++;
            }else if(b[1] < a[0]){
                j++;
            }else{
                int left = Math.max(a[0], b[0]);
                int right = Math.min(a[1], b[1]);
                List<Integer> interval = new ArrayList<Integer>();
                interval.add(left);
                interval.add(right);
                res.add(interval);
                if(a[1] == right){
                    i++;
                }else{
                    j++;
                }
            }
        }


        int[][] res_ = new int[res.size()][2];
        int x = 0;
        for(List<Integer> interval : res){
            res_[x][0] = interval.get(0);
            res_[x][1] = interval.get(1);
            x++;
        }
        return res_;
    }

}
