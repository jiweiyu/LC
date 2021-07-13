package leetcode;

import java.util.*;
public class LongestStringChain_1048 {

//    Let N be the number of words in the list and L be the maximum possible length of a word.
//
//    Time complexity: O(N (log N + L ^ 2))
//    Space complexity: O(N)

    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, (a,b) -> a.length() - b.length()); //O(NlogN)
        int res = 0;
        for(String word: words){   //time O(NSS), space O(NS)
            int best = 0;
            for(int i = 0;i < word.length(); i++){
                String prev = word.substring(0, i) + word.substring(i+1);
                best = Math.max(best, dp.getOrDefault(prev, 0) +1);
            }
            dp.put(word,best);
            res = Math.max(res, best);
        }
        return res;
    }
}
