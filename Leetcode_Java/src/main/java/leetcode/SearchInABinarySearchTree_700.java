package leetcode;

public class SearchInABinarySearchTree_700 {

    public TreeNode searchBST_recursion(TreeNode root, int val) {
        if(root == null || val == root.val) return root;
        return val < root.val ? searchBST_recursion(root.left, val) : searchBST_recursion(root.right, val);
    }

    public TreeNode searchBST_iteration(TreeNode root, int val) {
        while(root!=null || val!=root.val){
            root = val < root.val ? root.left : root.right;
        }
        return root;
    }
}
