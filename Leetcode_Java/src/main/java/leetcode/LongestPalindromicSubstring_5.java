package leetcode;

public class LongestPalindromicSubstring_5 {

    //faster
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    //slow
    public String longestPalindrome_(String s) {
         int n = s.length();
         String res = null;
         if(s.length()<2) return s;
         boolean[][] dp = new boolean[n][n];
         for(int i=0;i<n;i++){
             for(int j=i;j>=0;j--){
                 dp[i][j] = s.charAt(i)==s.charAt(j) && (i-j<3 || dp[i-1][j+1]);
                 if(dp[i][j] && (res==null || i-j+1>res.length())){
                     res = s.substring(j,i+1);
                 }
             }
         }
         return res;
    }

}
