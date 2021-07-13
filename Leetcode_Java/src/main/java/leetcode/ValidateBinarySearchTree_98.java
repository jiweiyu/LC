package leetcode;
import java.util.*;
public class ValidateBinarySearchTree_98 {

    public boolean isValidBST_inorder(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST_recursive(TreeNode root) {
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean valid(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val >= max || root.val <= min){
            return false;
        }
        return valid(root.left,min,root.val) && valid(root.right,root.val,max);
    }

}
