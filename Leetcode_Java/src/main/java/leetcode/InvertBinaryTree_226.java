package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree_226 {

    public TreeNode invertTree_recursion(TreeNode root) {
        if(root==null) return null;

        TreeNode right = invertTree_recursion(root.right);
        TreeNode left = invertTree_recursion(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if(current.left!=null) queue.add(current.left);
            if(current.right!=null) queue.add(current.right);
        }
        return root;
    }

}
