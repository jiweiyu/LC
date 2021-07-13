package leetcode;
import java.util.*;
public class DesignAuthenticationManager_1797 {

    private static HashMap<String, Integer> map;
    private static Integer timeToLive;

    public DesignAuthenticationManager_1797(int timeToLive) {
        this.map = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime);
    }

    public void renew(String tokenId, int currentTime) {
        if(map.containsKey(tokenId)){
            int t = map.get(tokenId);
            if((t + timeToLive) > currentTime){
                map.put(tokenId, currentTime);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int res = 0;
        for(Map.Entry<String, Integer> e : map.entrySet()){
            if((e.getValue() + timeToLive) > currentTime) res++;
        }
        return res;
    }
}
