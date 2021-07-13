package leetcode;
import java.util.*;
public class AllPathsFromSourceToTarget_797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        return dfsSearch(graph, 0, map);
    }

    private List<List<Integer>> dfsSearch(int[][] graph, int node, Map<Integer, List<List<Integer>>> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        List<List<Integer>> res = new ArrayList<>();
        if (node == graph.length - 1) {
            List<Integer> path = new LinkedList<>();
            path.add(node);
            res.add(path);
        } else {
            for (int nextNode : graph[node]) {
                List<List<Integer>> subPaths = dfsSearch(graph, nextNode, map);
                for (List<Integer> path : subPaths) {
                    LinkedList<Integer> newPath = new LinkedList<>(path);
                    newPath.addFirst(node);
                    res.add(newPath);
                }
            }
        }

        map.put(node, res);
        return res;
    }

    //backtracking
    public List<List<Integer>> allPathsSourceTarget_(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        backtracking(res, graph, 0, path);
        return res;
    }

    private void backtracking(List<List<Integer>> res, int[][] graph, int start, List<Integer> cur) {
        if(graph[start].length==0) {
            if(start==graph.length-1) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }

        for(int next:graph[start]) {
            cur.add(next);
            backtracking(res, graph, next, cur);
            cur.remove(cur.size()-1);
        }
    }
}
