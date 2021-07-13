package leetcode;


/*
Logic: In this problem we are required to find some interval [i:j] ,i < j where sum[i:j] = target. We know that sum[i:j] = A[i] + A[i+1] +... + A[j].
Then we also know that
Let's define prefixSum[j] = A[0] + A[1] + ... + A[j] 0 <= j <= n-1 (n = A.length)
It is easy to see that,
sum[i:j] = A[i] + A[i+1] ... + A[j] =
(A[0] + A[1] + ... A[i] ... + A[j]) - (A[0] + A[1] + ... A[i-1]) =
prefix[j] - prefix[i-1].

Now we the problem reduces to finding # of pairs (i, j) (i < j) such that
prefix[j] - prefix[i-1] = target
 */
public class BinarySubarraysWithSum_930 {

    public int BinarySubarraysWithSum_930(int[] A, int S){
        return atMost(A, S) - atMost(A, S-1);
    }

    public int atMost(int[] A, int S){
        if(S<0){
            return 0;
        }
        int res = 0, i = 0, n = A.length;
        for(int j = 0; j< n; j++){
            S -= A[j];
            while(S < 0){
                S += A[i++];
            }
            res += j - i + 1;
        }
        return res;
    }

}
