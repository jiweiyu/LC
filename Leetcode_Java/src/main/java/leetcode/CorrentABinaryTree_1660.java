package leetcode;
import java.util.*;
public class CorrentABinaryTree_1660 {

    Set<Integer> visited = new HashSet<>();

    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.right != null && visited.contains(root.right.val)) return null;
        visited.add(root.val);
        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);
        return root;
    }
}
