package leetcode;
import java.util.*;
public class PermutationInString_567 {

    //sliding window
    //O(l1 + (l2-l1))
    //O(1)
    public boolean checkInclusion_(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    //same as 438
    public boolean checkInclusion(String s2, String s1) {
        if(s2.length()>s1.length()) return false;
        HashMap<Character,Integer> map = new HashMap<>();

        for(char a : s2.toCharArray()){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int count = map.size();

        int start = 0, end = 0;
        while(end<s1.length()){
            char c = s1.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0){
                    count--;
                }
            }
            end++;

            while(count==0){
                char tempc = s1.charAt(start);
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc)+1);
                    if(map.get(tempc)>0){
                        count++;
                    }
                }
                if(end-start == s2.length()){
                    return true;
                }
                start++;
            }
        }
        return false;
    }
}
