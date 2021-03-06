package leetcode;

public class FlattenBinaryTreeToLinkedList_114 {

    private TreeNode prev = null;

    public void flatten(TreeNode root){
        if(root == null) return;

        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

}
