package leetcode;

public class TrimABinarySearchTree_669 {

    //O(n), O(n)
    public TreeNode trimBST_recursion(TreeNode root, int L, int R) {
        if(root == null) return root;
        if(root.val > R) return trimBST_recursion(root.left, L, R);
        if(root.val < L) return trimBST_recursion(root.right, L, R);

        root.left = trimBST_recursion(root.left, L, R);
        root.right = trimBST_recursion(root.right, L, R);
        return root;
    }

}
