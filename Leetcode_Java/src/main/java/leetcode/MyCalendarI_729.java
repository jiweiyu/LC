package leetcode;
import java.util.*;
public class MyCalendarI_729 {

    private List<int[]> books = new ArrayList<>();
    public boolean book(int start, int end) {
        for (int[] b : books)
            if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
        books.add(new int[]{ start, end });
        return true;
    }

    //TreeMap
    private TreeMap<Integer,Integer> map;

    public MyCalendarI_729() {
        map = new TreeMap<>();
    }

    public boolean book_(int start, int end) {
        map.put(start, map.getOrDefault(start,0)+1);
        map.put(end, map.getOrDefault(end,0)-1);

        int count=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            count+=entry.getValue();
            if(count>1){
                map.put(start, map.get(start)-1);
                if(map.get(start)==0) map.remove(start);
                map.put(end, map.get(end)+1);
                if(map.get(end)==0) map.remove(end);
                return false;
            }
        }
        return true;
    }

}
