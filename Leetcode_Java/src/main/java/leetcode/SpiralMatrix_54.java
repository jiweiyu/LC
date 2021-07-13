package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix==null || matrix[0] ==null) return res;

        int row = matrix.length;
        int col = matrix[0].length;
        int total = row*col;
        int ir = 0, ic = 0;
        int toprow = 0, topleft = 0;
        while(ir<row && ir>=toprow && ic<col && ic>=topleft && res.size()<total){
            while(ic<col && res.size()<total){
                res.add(matrix[ir][ic++]);
            }
            ic--;
            ir++;
            toprow++;
            while(ir<row && res.size()<total){
                res.add(matrix[ir++][ic]);
            }
            ir--;
            ic--;
            col--;
            while(ic>=topleft && res.size()<total){
                res.add(matrix[ir][ic--]);
            }
            ic++;
            ir--;
            row--;
            while(ir>=toprow && res.size()<total){
                res.add(matrix[ir--][ic]);
            }
            ir++;
            ic++;
            topleft++;
        }
        return res;
    }
}
