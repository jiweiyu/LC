package leetcode;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally_1329 {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<Integer, PriorityQueue<Integer>>();
        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                map.putIfAbsent(i-j, new PriorityQueue<Integer>());
                map.get(i-j).add(mat[i][j]);
            }
        }

        for(int i = 0 ; i < m; i++){
            for(int j = 0 ; j < n; j++){
                mat[i][j] = map.get(i-j).poll();
            }
        }
        return mat;
    }
}
