package Practice;

import java.util.HashSet;
import java.util.PriorityQueue;

/*
input是一个matrix和一个size，要把matrix分割成size*size的小matrix。matrix里所有都数都是正数，并保证能够被完整的分割。
比如给一个4*4的和size=2，就可以分成4个2*2的。
然后要给小matrix按照一定规则重新排列
定义了一个beauty值 = minimal missing number
如果submatrix是
【1，2】
【4，5】
那他的beauty就是 3
beauty值一样的就看谁排在前面，按照从左到右从上到下的顺序。
最后ouput重新排列过的matrix

举例：把下面这个分成2*2的
1，2｜5，4
4，5｜2，9
--------------
1，3｜2，4
9，6｜3，5

beauty分别是：
3｜1
------
2｜1

最后结果就应该是
原右上 -》左上
原右下 -》右上
原左下 -》左下
原左上 -》右下
5，4｜2，4
2，9｜3，5
--------------
1，3｜1，2
9，6｜4，5
 */
public class Uber_002 {

    public static int[][] sortBeauty(int[][] A, int K){
        int[][] res = A;
        if(A.length%K != 0 || K>A.length) return A; //invalid input

        int size = A.length/K;
        size = size*size;

        //int[][][] matrixList = new int[size][K][K];
        PriorityQueue<int[][]> pq = new PriorityQueue<>((a,b) -> (getBeauty(a)-getBeauty(b)));
        for(int i=0;i<size;i++){
            int[][] sub_matrix = new int[K][K];
            int s_row = size/K;
            int s_col = size%K;

            for(int r=s_row;r<s_row+K;r++) {
                for (int c = s_col; c < s_col + K; c++) {
                    sub_matrix[r - s_row][c - s_col] = A[r][c];
                }
            }
            pq.add(sub_matrix);
        }

        return A;




    }

    public static int getBeauty(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        HashSet<Integer> checkSet = new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                checkSet.add(matrix[i][j]);
            }
        }

        int beauty = 0;
        for(int i = 1;i<=checkSet.size();i++){
            if(!checkSet.contains(i)){
                beauty = i;
                break;
            }
        }
        return beauty;
    }

    public static void main(String[] args){
        int[][] A = new int[][]{{1,2,5,4},{4,5,2,9},{1,3,2,4},{9,6,3,5}};

        A = sortBeauty(A, 2);

        for(int[] a : A){
            System.out.println(a);
        }
    }

}
