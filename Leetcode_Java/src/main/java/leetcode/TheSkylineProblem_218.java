package leetcode;
import java.util.*;
public class TheSkylineProblem_218 {

    public List<List<Integer>> getSkyline_treemap(int[][] buildings) {
        // Key: position
        // Value: key=height, value=change
        var changes = new TreeMap<Integer,Map<Integer,Integer>>();
        for(var building:buildings) {
            int l=building[0],r=building[1],h=building[2];
            var left=changes.getOrDefault(l,new HashMap<>());
            var plus=left.getOrDefault(h,0)+1;
            left.put(h,plus);
            changes.put(l,left);
            var right=changes.getOrDefault(r,new HashMap<>());
            var minus=right.getOrDefault(h,0)-1;
            right.put(h,minus);
            changes.put(r,right);
        }

        var dest=new ArrayList<List<Integer>>();
        // Key: hight
        // Value: counts
        var state=new TreeMap<Integer,Integer>();
        int position=-1,hight=0;
        while(true) {
            // get next position and changes
            var change=changes.higherEntry(position);
            if(change==null) {
                // quit if no more change
                break;
            }
            // update position
            position=change.getKey();
            // update state
            for(var entry:change.getValue().entrySet()) {
                var h=entry.getKey();
                var cnt=state.getOrDefault(h,0)+entry.getValue();
                if(cnt==0) {
                    // remove height if count down to zerova
                    state.remove(h);
                } else {
                    state.put(h,cnt);
                }
            }

            var highest=0;
            // if state is empty, highest stay on 0
            if (!state.isEmpty()) highest=state.lastKey();

            if(highest!=hight) {
                // add new position if highest is different as previous and update hight
                dest.add(Arrays.asList(position,highest));
                hight=highest;
            }
        }

        return dest;
    }


        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> result = new ArrayList<>();
            List<int[]> height = new ArrayList<>();
            for(int[] b:buildings) {
                height.add(new int[]{b[0], -b[2]});
                height.add(new int[]{b[1], b[2]});
            }
            Collections.sort(height, (a, b) -> {
                if(a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            });
            Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
            pq.offer(0);
            int prev = 0;
            for(int[] h:height) {
                if(h[1] < 0) {
                    pq.offer(-h[1]);
                } else {
                    pq.remove(h[1]);
                }
                int cur = pq.peek();
                if(prev != cur) {
                    result.add(new int[]{h[0], cur});
                    prev = cur;
                }
            }
            return result;
        }
}
