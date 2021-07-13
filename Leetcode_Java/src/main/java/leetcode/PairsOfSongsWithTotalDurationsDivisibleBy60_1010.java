package leetcode;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60_1010 {

    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        if(time==null || time.length==0) return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : time){
            int rem = a%60;
            ans += map.getOrDefault((60-rem)%60, 0);
            map.put(rem, map.getOrDefault(rem,0)+1);
        }
        return ans;
    }

    public int numPairsDivisibleBy60_(int[] time) {
        int[] c = new int[60];
        int res = 0;
        for (int t : time) {
            res += c[(600 - t) % 60];
            c[t % 60] += 1;
        }
        return res;
    }
}
