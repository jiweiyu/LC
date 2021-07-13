package leetcode;

public class SearchA2DMatrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0||matrix[0]==null||matrix[0].length==0) return false;
        int r = matrix.length;
        int c = matrix[0].length;
        int end = r*c-1;
        int start = 0;
        while(start<end){
            int mid = (start+end-1)/2;
            int mid_r = mid/c;
            int mid_c = mid%c;
            if(matrix[mid_r][mid_c]==target) return true;
            else if(matrix[mid_r][mid_c]<target) start = mid+1;
            else end=mid;
        }
        return matrix[end/c][end%c]==target;
    }
}
