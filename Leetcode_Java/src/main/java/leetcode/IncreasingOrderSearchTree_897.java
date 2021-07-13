package leetcode;

public class IncreasingOrderSearchTree_897 {

    public TreeNode increasingBST(TreeNode root){
        return increasingBST(root, null);
    }

    public TreeNode increasingBST(TreeNode root, TreeNode tail){
        if(root==null) return tail;
        TreeNode res = increasingBST(root.left, root);
        root.left = null;
        root.right = increasingBST(root.right, tail);
        return res;
    }

    //method 2
    private TreeNode result;
    private TreeNode pre;
    public TreeNode increasingBST_2(TreeNode root) {
        inorder(root);
        return result;
    }
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (result == null) {
            result = root;
        } else {
            pre.right = root;
        }
        pre = root;
        root.left = null;
        inorder(root.right);
    }
}
