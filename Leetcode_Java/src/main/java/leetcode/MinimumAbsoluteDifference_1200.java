package leetcode;
import java.util.*;
public class MinimumAbsoluteDifference_1200 {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> res = new ArrayList();
        //sort elements
        Arrays.sort(arr);
        //init our min difference value
        int min = Integer.MAX_VALUE;
        //start looping over array to find real min element. Each time we found smaller difference
        //we reset resulting list and start building it from scratch. If we found pair with the same
        //difference as min - add it to the resulting list
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (diff == min) {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }

    public List<List<Integer>> minimumAbsDifference_jiwei(int[] arr) {
        Arrays.sort(arr);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]-a[0])==(b[1]-b[0])?(a[0]-b[0]):(a[1]-a[0])-(b[1]-b[0])));
        for(int i=0;i<arr.length-1;i++){
            pq.add(new int[]{arr[i],arr[i+1]});
        }

        int minDiff = pq.peek()[1]-pq.peek()[0];
        List<List<Integer>> res = new ArrayList<>();
        int n = pq.size();
        for(int i=0;i<n;i++){
            int[] a = pq.poll();
            if((a[1]-a[0])==minDiff){
                List<Integer> r = Arrays.asList(a[0],a[1]);
                res.add(r);
            }
        }
        return res;
    }
}
