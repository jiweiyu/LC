package leetcode;

public class InterleavingString_97 {

    //dfs
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray(), c3 = s3.toCharArray();
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        return dfs(c1, c2, c3, 0, 0, 0, new boolean[m + 1][n + 1]);
    }

    public boolean dfs(char[] c1, char[] c2, char[] c3, int i, int j, int k, boolean[][] invalid) {
        if(invalid[i][j]) return false;
        if(k == c3.length) return true;
        boolean valid =
                i < c1.length && c1[i] == c3[k] && dfs(c1, c2, c3, i + 1, j, k + 1, invalid) ||
                        j < c2.length && c2[j] == c3[k] && dfs(c1, c2, c3, i, j + 1, k + 1, invalid);
        if(!valid) invalid[i][j] = true;
        return valid;
    }

    //dp
    public boolean isInterleave_dp(String s1, String s2, String s3) {

        if(s1.length()+s2.length()!=s3.length()) return false;
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;

        int i=1;
        while(i<dp.length && dp[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1)){
            dp[i++][0]=true;
        }
        i=1;
        while(i<dp[0].length && dp[0][i-1] && s2.charAt(i-1)==s3.charAt(i-1)){
            dp[0][i++]=true;
        }

        for(int y=1;y<dp.length;y++){
            for(int x=1;x<dp[0].length;x++){
                dp[y][x] = (dp[y-1][x]&&(s1.charAt(y-1)==s3.charAt(y+x-1)))
                        || (dp[y][x-1]&&s2.charAt(x-1)==s3.charAt(y+x-1));
            }
        }
        return dp[s1.length()][s2.length()];

    }
}
