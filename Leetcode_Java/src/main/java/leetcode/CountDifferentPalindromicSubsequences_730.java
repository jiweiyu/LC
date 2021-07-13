package leetcode;
import java.util.*;
public class CountDifferentPalindromicSubsequences_730 {


    //1, brute force O(n2^n)
    public int countPalindromicSubsequences_1(String S) {
        Set<String> set=new HashSet<>();
        palindromicSubsequences("",0,S,set);
        return set.size()-1;
    }
    private void palindromicSubsequences(String cur, int i, String s, Set<String> set) {
        if(i==s.length()) {
            if(isPal(cur)) set.add(cur);
            return;
        }
        palindromicSubsequences(cur,i+1,s,set);
        palindromicSubsequences(cur+s.charAt(i),i+1,s,set);
    }
    private boolean isPal(String s){
        int l=0,r=s.length()-1;
        while(l<r&&s.charAt(l)==s.charAt(r)) {
            l++;
            r--;
        }
        return l>=r;
    }

    //2, O(3^n)
    public int countPalindromicSubsequences_2(String S) {
        return count(0,S.length()-1,S);
    }
    private int count(int i, int j, String s) {
        if(i>j) return 0;
        if(i==j) return 1;
        int num=0;
        if(s.charAt(i)==s.charAt(j)) {
            num=2*count(i+1,j-1,s); //a....a add two ends to every inner palindorm, there are duplicates in case of a...a...a...a
            int left=i+1, right=j-1; //still need to figure out how to count the two ends and avoid duplicates
            while(left<=right&&s.charAt(left)!=s.charAt(i)) left++;
            while(left<=right&&s.charAt(right)!=s.charAt(i)) right--;
            //a...a...a...a
            if(left<right) num-=count(left+1,right-1,s); //no need to add two ends to the palindomes between inner 2a
            else if(left==right) num+=1; //a...a...a, add aa
            else num+=2; //a...a, add a, aa
        } else num=count(i+1,j,s)+count(i,j-1,s)-count(i+1,j-1,s);
        return num;
    }

    //3, memoization
    public int countPalindromicSubsequences_3(String S) {
        int n=S.length();
        int[][] mem=new int[n][n];
        return count(0,n-1,S,mem);
    }
    private int count(int i, int j, String s, int[][] mem) {
        if(i>j) return 0;
        if(i==j) return 1;
        if(mem[i][j]!=0) return mem[i][j];
        int num=0;
        if(s.charAt(i)==s.charAt(j)) {
            num=2*count(i+1,j-1,s,mem); //a....a add two ends to every inner palindorm, there are duplicates if ... has a...a
            //need to figure out how to count the two ends and avoid duplicates
            int left=i+1, right=j-1;
            while(left<=right&&s.charAt(left)!=s.charAt(i)) left++;
            while(left<=right&&s.charAt(right)!=s.charAt(i)) right--;
            //a...a...a...a
            if(left<right) num-=count(left+1,right-1,s,mem); //no need to add two ends to the palindomes between inner 2a
            else if(left==right) num+=1; //a...a...a, add aa
            else num+=2; //a...a, add a, aa
        } else num=count(i+1,j,s,mem)+count(i,j-1,s,mem)-count(i+1,j-1,s,mem);
        return mem[i][j]=num<0?num+1000000007:num%1000000007;
    }

    //4, dp
    public int countPalindromicSubsequences_4(String S) {
        int n=S.length();
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++) dp[i][i]=1;
        for(int l=2;l<=n;l++) {
            for(int i=0;i<n-l+1;i++) {
                int j=i+l-1;
                if(S.charAt(i)==S.charAt(j)) {
                    int left=i+1, right=j-1;
                    dp[i][j]=2*dp[i+1][j-1];
                    while(left<=right&&S.charAt(left)!=S.charAt(i)) left++;
                    while(left<=right&&S.charAt(right)!=S.charAt(i)) right--;
                    if(left<right) dp[i][j]-=dp[left+1][right-1]; //no need to add two ends to the palindomes between inner 2a
                    else if(left==right) dp[i][j]+=1; //a...a...a, add aa
                    else dp[i][j]+=2; //a...a, add a, aa
                } else dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                dp[i][j]=dp[i][j]<0?dp[i][j]+1000000007:dp[i][j]%1000000007;
            }
        }
        return dp[0][n-1];
    }


    public int countPalindromicSubsequences(String s){
        int len = s.length();
        int[][] dp = new int[len][len];

        char[] chs = s.toCharArray();
        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }
        for(int distance = 1;distance<len;distance++) {
            for (int i = 0; i < len - distance; i++) {
                int j = i + distance;
                if (chs[i] == chs[j]) {
                    int low = i + 1;
                    int high = j - 1;

                    while (low <= high && chs[low] != chs[j]) {
                        low++;
                    }
                    while (low <= high && chs[high] != chs[j]) {
                        high--;
                    }

                    if (low > high) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (low == high) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                    }
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][len-1];
    }

}
