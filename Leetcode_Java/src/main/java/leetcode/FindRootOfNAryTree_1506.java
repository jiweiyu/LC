package leetcode;
import java.util.*;
public class FindRootOfNAryTree_1506 {

    //Time: O(n) for first loop, O(n) for 2nd loop - total O(n) time
    //Space: O(1) space
    public Node findRoot_(List<Node> tree) {
        // Edge Case
        if (tree==null || tree.size()==0) return null;

        long sum=0;

        // For each node in the tree
        for (Node node : tree){
            // Add current node value to sum
            sum+=node.val;

            // For each child - reduce value of child from sum
            for (Node child : node.children)
                sum-=child.val;
        }

        // Remaining value in sum is the only node that doesn't have a parent (meaning isn't a child of any other node) - which is the root.
        for (Node node : tree)
            if (node.val==sum) return node;

        return null;
    }

    //Time: O(n) for first loop, O(n) for 2nd loop - total O(n) time
    //Space: O(n) space for the "seen" set
    public Node findRoot(List<Node> tree) {
        // Edge Case
        if (tree==null || tree.size()==0) return null;

        Set<Node> seen = new HashSet<>();

        // For each node in the tree
        for (Node node : tree){
            // For each child of the current node
            for (Node child : node.children)
                seen.add(child);
        }

        // For each node in the tree, if node doesn't exist in the set, return it as it's our root
        for (Node node : tree)
            if (!seen.contains(node)) return node;

        return null;
    }

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
