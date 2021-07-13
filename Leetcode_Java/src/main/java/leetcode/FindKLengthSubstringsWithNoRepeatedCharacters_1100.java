package leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters_1100 {


    public int numKLenSubstrNoRepeats_1(String S, int K) {
        Set<Character> seen = new HashSet<>();
        int ans = 0;
        for (int hi = 0, lo = 0; hi < S.length(); ++hi) {
            while (!seen.add(S.charAt(hi))) // if duplicate char in window [lo, hi]
                seen.remove(S.charAt(lo++)); // shrink window by increasing low bound.
            if (seen.size() > K) // if the window wider than K.
                seen.remove(S.charAt(lo++)); // shrink the window by increasing low bound.
            if (seen.size() == K) // a solution found.
                ++ans;
        }
        return ans;
    }

    //O(n)
    public int numKLenSubstrNoRepeats_2(String S, int K) {
        HashSet<Character> cur = new HashSet<>();
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); ++j) {
            while (cur.contains(S.charAt(j)))
                cur.remove(S.charAt(i++));
            cur.add(S.charAt(j));
            res += j - i + 1 >= K ? 1 : 0;
        }
        return res;
    }

    //(KS)
    public int numKLenSubstrNoRepeats_3(String S, int K) {
        if(S==null || S.length()==0 || K>S.length()) return 0;
        int[] check = new int[26];
        int i=0,j=0,res=0;
        for(;i<S.length() && j<S.length();i++){

            char c = S.charAt(i);
            check[c-'a']++;
            if(check[c-'a']>1){
                while(check[c-'a']>1  && j<=i){
                    char rm = S.charAt(j);
                    check[rm-'a']--;
                    j++;
                }
            }
            int len = i-j+1;
            if(len==K){
                //System.out.println("i: " + i + ",j: " + j);
                res++;
                char rm = S.charAt(j);
                check[rm-'a']--;
                j++;
            }
        }
        return res;
    }
}
