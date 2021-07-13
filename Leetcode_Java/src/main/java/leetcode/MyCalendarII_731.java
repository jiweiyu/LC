package leetcode;
import java.util.*;
public class MyCalendarII_731 {


    List<int[]> calendar;
    List<int[]> overlaps;

    MyCalendarII_731() {
        calendar = new ArrayList();
        overlaps = new ArrayList();
    }

    public boolean book__(int start, int end) {
        for (int[] iv: overlaps) {
            if (iv[0] < end && start < iv[1]) return false;
        }
        for (int[] iv: calendar) {
            if (iv[0] < end && start < iv[1])
                overlaps.add(new int[]{Math.max(start, iv[0]), Math.min(end, iv[1])});
        }
        calendar.add(new int[]{start, end});
        return true;
    }

    /*
a:                     |---------|
b:
a0<b0 & a1<b0:  |----|
a0<b0 & a1>b0:  |------------| (a started within b)
a0<b0 & a1>b1:  |-------------------| (a started within b)
a0>b0 & a0<b1:            |----|  (b started within a)
a0>b0 & a0>b1:            |---------| (b started within a)
a0>b1 & a1>b1:                      |----|
     */


    private List<int[]> books = new ArrayList<>();
    public boolean book(int s, int e) {
        MyCalendar overlaps = new MyCalendar();
        for (int[] b : books)
            if (Math.max(b[0], s) < Math.min(b[1], e)) // overlap exist
                if (!overlaps.book(Math.max(b[0], s), Math.min(b[1], e))) return false; // overlaps overlapped
        books.add(new int[]{ s, e });
        return true;
    }

    private static class MyCalendar {
        List<int[]> books = new ArrayList<>();
        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{ start, end });
            return true;
        }
    }

    //TreeMap

    private TreeMap<Integer, Integer> map;

//    public MyCalendarTwo() {
//        map = new TreeMap<>();
//    }


    //O(N^2)
    //O(N)
    public boolean book_(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            count += entry.getValue();
            if(count > 2) {
                map.put(start, map.get(start) - 1);
                if(map.get(start) == 0) {
                    map.remove(start);
                }
                map.put(end, map.get(end) + 1);
                if(map.get(end) == 0) {
                    map.remove(end);
                }
                return false;
            }
        }
        return true;
    }
}
