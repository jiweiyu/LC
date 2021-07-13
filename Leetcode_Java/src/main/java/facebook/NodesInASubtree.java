package facebook;
import java.util.*;
public class NodesInASubtree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
            val = 0;
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Query {
        int u;
        char c;
        Query(int u, char c) {
            this.u = u;
            this.c = c;
        }
    }

    private Map<Character, Integer> dfs(Node node, String s, Map<Integer, Map<Character, Integer>> countMap) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        charCountMap.put(s.charAt(node.val - 1), 1);

        for (Node child : node.children) {
            for (Map.Entry<Character, Integer> entry : dfs(child, s, countMap).entrySet()) {
                charCountMap.put(entry.getKey(), charCountMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }

        countMap.put(node.val, charCountMap);
        return charCountMap;
    }

    int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
        int[] result = new int[queries.size()];

        Map<Integer, Map<Character, Integer>> countMap = new HashMap<>();
        dfs(root, s, countMap);

        int index = 0;
        for (Query q : queries) {
            result[index++] = countMap.get(q.u).getOrDefault(q.c, 0);
        }

        return result;
    }
}
