package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOfABinaryTreeIII_1650 {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };

    //O(N),
    //O(N)
    public Node lowestCommonAncestor(Node p, Node q) {
        List<Node> path = find_Path(p);
        while (q.parent != null) {
            for (Node node : path) {
                if (node == q) return q;
            }
            q = q.parent;
        }
        return q;
    }

    public List<Node> find_Path(Node p) {
        List<Node> path = new ArrayList<>();
        while (p.parent != null) {
            path.add(p);
            p = p.parent;
        }
        return path;
    }


    public Node lowestCommonAncestor_(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a == null? q : a.parent;
            b = b == null? p : b.parent;
        }
        return a;
    }
}
