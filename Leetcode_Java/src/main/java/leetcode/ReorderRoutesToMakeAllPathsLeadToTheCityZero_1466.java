package leetcode;
import java.util.*;
public class ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466 {

    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> undirected = getUndirectedMap(n, connections);
        Map<Integer, Set<Integer>> directed = getDirectedMap(n, connections);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        helper(undirected, directed, 0, visited);
        return ans;
    }

    public void helper(Map<Integer, Set<Integer>> undirected, Map<Integer, Set<Integer>> directed, int node, Set<Integer> visited) {
        for (Integer nei : undirected.get(node)) {
            if (!visited.contains(nei)) {
                visited.add(nei);
                if (!directed.get(nei).contains(node)) {
                    ans++;
                }
                helper(undirected, directed, nei, visited);
            }
        }
    }

    public Map<Integer, Set<Integer>> getUndirectedMap(int n, int[][] connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] conn : connections) {
            map.get(conn[0]).add(conn[1]);
            map.get(conn[1]).add(conn[0]);
        }
        return map;
    }

    public Map<Integer, Set<Integer>> getDirectedMap(int n, int[][] connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int[] conn : connections) {
            map.get(conn[0]).add(conn[1]);
        }
        return map;
    }
}
