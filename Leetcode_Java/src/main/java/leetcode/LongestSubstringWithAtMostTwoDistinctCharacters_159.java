package leetcode;

import java.util.HashMap;

public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int res = 0;
        for(int i=0, j=0; i<n && j<n;j++){

            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)+1);
            while(map.size()>2){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
                i++;
            }
            res = Math.max(res, j-i+1);
        }
        return res;
    }
}
