package facebook;
import java.util.*;
public class MatchingPairs {

    int matchingPairs(String s, String t) {
        // Write your code here
        int matchCount = 0;
        Map<String, int[]> hm = new HashMap<>();
        Map<Character, Integer> hmMatch = new HashMap<>();
        Set<Character> unMatchedS = new HashSet<>();
        Set<Character> unMatchedT = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i)) {
                if(!hmMatch.containsKey(s.charAt(i))) {
                    hmMatch.put(s.charAt(i), 1);
                }
                else {
                    hmMatch.put(s.charAt(i), hmMatch.get(s.charAt(i)) + 1);
                }
                matchCount++;
            }
            else {
                String key = "";
                int val = 0;
                unMatchedS.add(s.charAt(i));
                unMatchedT.add(t.charAt(i));

                if(s.charAt(i) < t.charAt(i)){
                    key = key +  s.charAt(i) + t.charAt(i);
                    val = 0;
                }
                else{
                    key = key +  t.charAt(i) + s.charAt(i);
                    val = 1;
                }

                if(!hm.containsKey(key)) {
                    int[] valList = new int[2];
                    valList[val]++;
                    hm.put(key, valList);
                }
                else {
                    hm.get(key)[val]++;
                }
            }
        }

        for(String key : hm.keySet()) {
            if(hm.get(key)[0] > 0 && hm.get(key)[1] > 0) {
                return matchCount + 2;
            }
        }


        boolean flag = false;

        // Multiple mismatch, but perfect swap is not possible
        for(String key : hm.keySet()) {
            char char0 = key.split("_")[0].charAt(0);
            char char1 = key.split("_")[1].charAt(0);
            if((hm.get(key)[0] > 0 && (unMatchedS.contains(char1) || unMatchedT.contains(char0)))
                    || (hm.get(key)[1] > 0 && (unMatchedS.contains(char0) || unMatchedT.contains(char1)))) {
                return matchCount + 1;
            }
            if(hm.get(key)[0] > 1 || hm.get(key)[1] > 1) {
                flag = true;
            }

        }

        if(flag) {
            return matchCount;
        }

        // Exactly one mismatch
        for(String key : hm.keySet()) {
            char char0 = key.split("_")[0].charAt(0);
            char char1 = key.split("_")[1].charAt(0);
            if(hmMatch.containsKey(char0) || hmMatch.containsKey(char1)) {
                return matchCount;
            }
            else {
                return matchCount - 1;
            }
        }

        // No mismatch
        if(hm.size() == 0) {
            for(Character key : hmMatch.keySet()) {
                if(hmMatch.get(key) > 1) {
                    return matchCount;
                }
            }
            return matchCount - 2;
        }
        return -1;
    }
}
