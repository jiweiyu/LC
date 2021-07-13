package leetcode;

public class MaxConsecutiveOnesIII_1004 {

    public int longestOnes(int[] A, int K) {
        int i = 0, j, res = 0;
        for(j=0;j<A.length;j++){
            if(A[j] == 0) K--;
            while(K<0){
                if(A[i]==0){
                    K++;
                }
                i++;
            }
            res = Math.max(res,j-i+1);
        }
        return res;
    }
}
