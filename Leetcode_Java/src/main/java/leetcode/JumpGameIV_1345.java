package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class JumpGameIV_1345 {
    public int minJumps(int[] arr){
        int n = arr.length;
        HashMap<Integer, List<Integer>> indecesOfValue = new HashMap<>();
        for(int i = 0; i<n; i++){
            indecesOfValue.computeIfAbsent(arr[i], x->new LinkedList<>()).add(i);
        }
        boolean[] visited = new boolean[n]; visited[0] = true;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        int step = 0;
        while(!q.isEmpty()){
            for(int size = q.size();size>0;--size){
                int i = q.poll();
                if(i==n-1) return step;
                List<Integer> next = indecesOfValue.get(arr[i]);
                next.add(i-1);
                next.add(i+1);
                for(int j : next){
                    if(j>=0 && j<n && !visited[j]){
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear();
            }
            step++;
        }
        return 0;
    }
}
