package leetcode;

import java.util.PriorityQueue;
import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttended_1353 {

    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // minHeap
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); //sort events increasing by start time
        int i = 0, res = 0, n = events.length;
        for(int d =1; d<=100000; d++){
            while(!pq.isEmpty() && pq.peek() < d){
                pq.poll();  // remove events that are already closed
            }
            while(i < n && events[i][0] == d){
                pq.offer(events[i++][1]); //Add new events that can attend on day d
            }
            if(!pq.isEmpty()){
                res++;
                pq.poll(); // use day d to attend to the event close earlier
            }
        }
        return res;
    }
}
