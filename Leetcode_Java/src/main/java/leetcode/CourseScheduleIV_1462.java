package leetcode;
import java.util.*;
public class CourseScheduleIV_1462 {

    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        List<Boolean> res = new ArrayList<>();

        boolean[][] connect = new boolean[n][n];
        int a = prerequisites.length;
        for(int i=0;i<a;i++){
            connect[prerequisites[i][0]][prerequisites[i][1]] = true;
        }

        for(int k =0;k<n;k++){
            for(int i = 0; i<n; i++){
                for(int j=0; j<n; j++){
                    connect[i][j] = connect[i][j] || connect[i][k] && connect[k][j];
                }
            }
        }

        for(int[] q : queries){
            res.add(connect[q[0]][q[1]]);
        }
        return res;
    }
}
