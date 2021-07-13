package leetcode;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks_1167 {

    public int connectSticks(int[] sticks){
        int res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s: sticks) pq.add(s);

        while(pq.size()>1){
            int cost = pq.poll()+pq.poll();
            res += cost;
            pq.add(cost);
        }
        return res;
    }
}
