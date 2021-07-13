package leetcode;
import java.util.*;
public class MyCalendarIII_732 {


    //O(N^2)
    //O(N)
    private TreeMap<Integer, Integer> map;
    public MyCalendarIII_732() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0, res = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            res = Math.max(res, count);
        }
        return res;
    }
}
