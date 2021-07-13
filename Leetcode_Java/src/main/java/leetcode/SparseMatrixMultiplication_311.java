package leetcode;

public class SparseMatrixMultiplication_311 {

    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int nA = A[0].length;
        int n = B[0].length;
        int[][] res = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < nA; j++){
                if(A[i][j] != 0){
                    for(int k = 0; k < n; k++){
                        if(B[j][k] != 0){
                            res[i][k] += A[i][j] * B[j][k];
                        }
                    }
                }

            }
        }
        return res;
    }
}
