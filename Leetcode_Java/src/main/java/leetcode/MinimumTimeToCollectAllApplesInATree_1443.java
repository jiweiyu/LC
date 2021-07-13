package leetcode;
import java.util.*;
public class MinimumTimeToCollectAllApplesInATree_1443 {

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge : edges){
            List<Integer> a = map.getOrDefault(edge[0], new ArrayList<Integer>());
            List<Integer> b = map.getOrDefault(edge[1], new ArrayList<Integer>());
            a.add(edge[1]);
            b.add(edge[0]);
            map.put(edge[0], a);
            map.put(edge[1], b);
        }
        HashSet<Integer> visited = new HashSet<Integer>();

        return dfs(0, hasApple, map, visited);
    }


    int dfs(int node, List<Boolean> hasApple, HashMap<Integer, List<Integer>> map, Set<Integer> visited){
        visited.add(node);
        int res = 0;
        for(int a : map.getOrDefault(node, new ArrayList<Integer>())){
            if(visited.contains(a)) continue;
            res += dfs(a, hasApple, map, visited);
        }
        if((res > 0 || hasApple.get(node)) && node != 0){
            res += 2;
        }
        return res;
    }
}
