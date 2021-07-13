package facebook;
import java.util.*;
public class QueueRemovals {


    int[] findPositions(int[] arr, int x) {
        // Write your code here
        int[] result = new int[x];
        Queue<int[]> queue = new LinkedList();
        for(int i=0;i<arr.length;i++){
            queue.offer(new int[]{arr[i],i+1});
        }
        int i=0;
        while(i<x && !queue.isEmpty()){
            int size = x;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[0]==a[0]?a[1]-b[1]:b[0]-a[0]);
            Queue<int[]> temp = new LinkedList();
            while(size>0 && !queue.isEmpty()){
                int[] ele = queue.poll();
                pq.offer(ele);
                temp.offer(ele); //This  is needed to maintain original order of elements in the queue.
                size--;
            }
            int[] max = pq.poll();
            result[i++]=max[1];
            while(!temp.isEmpty()){
                int[] ele = temp.poll();
                if(ele[0]==max[0] && ele[1]==max[1]){ // or we can do if(max==ele) or Arrays.equals(max, ele)
                    continue;
                }
                if(ele[0]!=0){
                    ele[0]--;
                }
                queue.offer(ele);
            }
        }
        return result;
    }

}
