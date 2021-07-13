package leetcode;

import java.util.HashMap;

public class LoggerRateLimiter_359 {

    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter_359() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        boolean res;
        if(map.containsKey(message)){
            if(timestamp - map.get(message) >= 10){
                res = true;
                map.put(message, timestamp);
            }else{
                res = false;
            }
        }else{
            res = true;
            map.put(message, timestamp);
        }

        return res;
    }
}
