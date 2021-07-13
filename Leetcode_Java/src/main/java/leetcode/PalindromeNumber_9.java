package leetcode;

public class PalindromeNumber_9 {

    //O(1) space, O(lgn)
    public boolean isPalindrome(int x) {

        if (x < 0) return false;

        int p = x;
        int q = 0;

        while (p >= 10){
            q *=10;
            q += p%10;
            p /=10;
        }

        return q == x / 10 && p == x % 10;
    }

    public boolean isPalindrome_jiwei(int x) {
        if(x<0) return false;
        String s = String.valueOf(x);
        int i = 0, j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
