package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters_3 {

    public int lengthOfLongestSubstring_On(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }


    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int start = 0, end = 0, len = s.length();
        HashSet<Character> set = new HashSet<Character>();
        int res = 0;
        while(start<len && end<len){
            char c = s.charAt(end);
            if(!set.add(c) && start<=end){
                while(set.contains(c)){
                    set.remove(s.charAt(start++));
                }
            }
            set.add(c);
            res = Math.max(res, end-start+1);
            //System.out.println("start,"+start+";end, "+end+","+res + ", " + s.substring(start,res));
            end++;
        }
        return res;
    }
}
