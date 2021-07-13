package leetcode;
import java.util.*;
public class FindEventualSafeStates_802 {

    /*
    0:have not been visited
    1:safe
    2:unsafe
     */
//    Time complexity: O(V + E)
//    Space complexity: O(V + E)

    public List<Integer> eventualSafeNodes(int[][] graph){
        List<Integer> res = new ArrayList<>();
        if(graph == null || graph.length == 0) return res;

        int nodeCount = graph.length;
        int[] color = new int[nodeCount];

        for(int i = 0; i < nodeCount; i++){
            if(dfs(graph, i, color)) res.add(i);
        }
        return res;
    }

    private boolean dfs(int[][] graph, int start, int[] color){
        if(color[start] != 0) return color[start] == 1;
        color[start] = 2;
        for(int newNode : graph[start]){
            if(!dfs(graph, newNode, color)) return false;
        }
        color[start] = 1;
        return true;
    }

}
