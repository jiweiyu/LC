package leetcode;

public class NumbersAtMostNGivenDigitSet_902 {

    public int atMostNGivenDigitSet(String[] D, int N){
        String S = String.valueOf(N);
        int K = S.length();
        int[] dp = new int[K+1];
        dp[K] = 1;


        //same length with N
        for(int i=K-1;i>=0;i--){
            int Si = S.charAt(i) - '0';
            for(String d : D){
                if(Integer.valueOf(d)<Si)
                    dp[i] += Math.pow(D.length, K-i-1);
                else if(Integer.valueOf(d)==Si)
                    dp[i] += dp[i+1];
            }
        }

        //length smaller than N
        for(int i=1;i<K;i++){
            dp[0] += Math.pow(D.length, i);
        }

        return dp[0];
    }
}
