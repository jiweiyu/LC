package leetcode;

import java.util.HashMap;

public class FourSumII_454 {

    //Time complexity:  O(n^2)
    //Space complexity: O(n^2)
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }

        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                res += map.getOrDefault(-(C[i]+D[j]),0);
            }
        }

        return res;
    }
}
