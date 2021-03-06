package leetcode;

import java.util.HashMap;

public class LongestWellPerformingInterval_1124 {
    public int longestWPI(int[] hours) {
        HashMap<Integer, Integer> seen = new HashMap<Integer,Integer>();
        int res = 0, score = 0, n = hours.length;
        for(int i = 0; i < n; i++){
            score += hours[i] > 8 ? 1 : -1;
            if(score > 0){
                res = i+1;
            }else{
                seen.putIfAbsent(score, i);
                if(seen.containsKey(score-1)){
                    res = Math.max(res, i-seen.get(score-1));
                }
            }
        }
        return res;
    }
}
