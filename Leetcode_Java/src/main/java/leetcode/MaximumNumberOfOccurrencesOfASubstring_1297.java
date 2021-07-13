package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;

public class MaximumNumberOfOccurrencesOfASubstring_1297 {

    //O(n*minSize).
    public int maxFreq_linear(String s, int maxLetters, int minSize, int maxSize) {
        if(s == null || s.length() == 0 || maxLetters == 0) return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        int max = 0;
        for(int i = 0; i < s.length() - minSize + 1; i++) {
            String cur = s.substring(i, i + minSize);
            if(isValid(cur, maxLetters)) {
                hm.put(cur, hm.getOrDefault(cur, 0) + 1);
                max = Math.max(max, hm.get(cur));
            }
        }
        return max;
    }

    boolean isValid(String cur, int maxLetters) {
        // length of cur  = minSize and makes this method run O(1)
        HashSet<Character> hs = new HashSet<>();
        for(char c: cur.toCharArray()) hs.add(c);
        return hs.size() <= maxLetters;
    }

    public int maxFreq_array(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0, n = s.length();
        Map<String, Integer> map = new HashMap<>();
        int[] arr = new int[26];
        int count = 0; //count diff character in array
        for (int i = 0; i < n - minSize + 1; i++) {
            String sub = s.substring(i, i + minSize);
            if (i == 0) {
                for (char c : sub.toCharArray()) {
                    arr[c - 'a']++;
                    if (arr[c - 'a'] == 1) count++;
                }
            } else {
                int l = s.charAt(i - 1) - 'a';
                int r = sub.charAt(minSize - 1) - 'a';
                arr[l]--;
                if (arr[l] == 0) count--;
                arr[r]++;
                if (arr[r] == 1) count++;
            }

            if (count > maxLetters) continue;
            map.put(sub, map.getOrDefault(sub, 0) + 1);
            res = Math.max(res, map.get(sub));
        }
        return res;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> res = new HashMap<>();
        int n = s.length(), resCnt = 0;
        if(minSize > n) return 0;
        for(int i = 0; i < n; i++){
            Map<Character, Integer> map = new HashMap<>();
            for(int distNum = 0, j = 0; j < maxSize; j++){
                if(i + j >= n) break;
                map.put(s.charAt(i + j), map.getOrDefault(s.charAt(i + j), 0) + 1);
                if(map.get(s.charAt(i + j)) == 1) distNum++;
                if(distNum > maxLetters) break;
                if(j >= minSize - 1)
                    res.put(s.substring(i, i + j + 1), res.getOrDefault(s.substring(i, i + j + 1), 0) + 1);
            }
        }
        for(String str: res.keySet()){
            if(res.get(str) > resCnt)
                resCnt = res.get(str);
        }
        return resCnt;
    }
}
