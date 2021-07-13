package leetcode;

import java.io.CharConversionException;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MinimumWindowSubstring_76 {

    public String minWindow(String S, String T) {

        HashMap<Character,Integer> map = new HashMap<>();
        for(char a : T.toCharArray()){
            map.put(a, map.getOrDefault(a,0)+1);
        }

        int start = 0, end = 0, counter = T.length();
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int size = S.length();

        while(end < size){
            if(map.getOrDefault(S.charAt(end),0)>0) counter--;
            map.put(S.charAt(end), map.getOrDefault(S.charAt(end),0)-1);
            end++;

            while(counter==0){
                if(end-start < minLen){
                    minStart = start;
                    minLen = end - start;
                }
                map.put(S.charAt(start), map.getOrDefault(S.charAt(start), 0)+1);
                if(map.get(S.charAt(start)) > 0) counter++;
                start++;
            }
        }
        if(minLen!=Integer.MAX_VALUE) return S.substring(minStart, minStart+minLen);
        return "";

    }

}
