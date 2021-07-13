package leetcode;
import java.util.*;
public class HighFive_1086 {
    public int[][] highFive(int[][] items) {

        HashMap<Integer,PriorityQueue<Integer>> map = new HashMap<>();
        for(int i=0;i<items.length;i++){
            if(!map.containsKey(items[i][0])) map.put(items[i][0], new PriorityQueue<Integer>((a,b)->(b-a)));
            PriorityQueue<Integer> pq = map.get(items[i][0]);
            pq.offer(items[i][1]);
            map.put(items[i][0], pq);
        }

        int[][] res = new int[map.size()][2];
        double avg = 0.0;
        int rescount = 0;

        for(Map.Entry<Integer,PriorityQueue<Integer>> entry : map.entrySet()){
            int id = entry.getKey();
            avg = 0.0;
            PriorityQueue<Integer> pq = entry.getValue();
            int count = Math.min(5,pq.size());
            //System.out.println("count:"+count+","+pq.size());
            for(int i=0;i<count;i++){
                avg += pq.poll();
            }
            //System.out.println("id:"+id+",avg:"+avg+",count:"+count);
            avg = avg /count;
            res[rescount][0] = id;
            res[rescount][1] = (int) (avg/1.0);
            rescount++;
        }
        return res;
    }

}
