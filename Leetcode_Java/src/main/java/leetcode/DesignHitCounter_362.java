package leetcode;
import java.util.*;
public class DesignHitCounter_362 {

    TreeMap<Integer,Integer> cnt;

    /** Initialize your data structure here. */
    public DesignHitCounter_362() {
        cnt = new TreeMap<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        cnt.put(timestamp, cnt.getOrDefault(timestamp,0)+1);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        if(cnt.containsKey(timestamp)){
            total += cnt.get(timestamp);
        }
        int check_timestamp = timestamp;
        while(cnt.lowerEntry(check_timestamp)!=null && timestamp-cnt.lowerKey(check_timestamp)<300){
            total += cnt.lowerEntry(check_timestamp).getValue();
            check_timestamp = cnt.lowerKey(check_timestamp);
        }
        return total;
    }
}
