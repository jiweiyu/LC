package leetcode;

public class SmallestRangeI_908 {

    public int smallestRangeI(int[] A, int K){
        int mx = A[0], mn = A[0];
        for(int a : A){
            mx = Math.max(mx, a);
            mn = Math.min(mn, a);
        }
        return Math.max(0, mx-mn-2*K);
    }
}
