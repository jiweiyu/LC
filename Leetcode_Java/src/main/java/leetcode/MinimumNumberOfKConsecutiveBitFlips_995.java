package leetcode;

public class MinimumNumberOfKConsecutiveBitFlips_995 {

    public int minKBitFlips(int[] A, int K) {
        int N = A.length;
        int[] hint = new int[N];
        int ans = 0, flip = 0;

        for(int i = 0; i<N; i++){
            flip ^= hint[i];
            if(A[i] == flip){
                ans++;
                if(i+K > N) return -1;
                flip ^= 1;
                if(i+K < N) hint[i+K] ^= 1;
            }
        }
        return ans;
    }

    ///////////
    private void flip(int[]A,int K,int i){
        for(int j=i;j<i+K;j++){
            A[j]=1-A[j];
        }
    }

    public int minKBitFlips_(int[] A, int K) {
        int cnt=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                if(i+K>A.length)return -1;
                flip(A,K,i);
                cnt++;
            }
        }
        return cnt;
    }

}
