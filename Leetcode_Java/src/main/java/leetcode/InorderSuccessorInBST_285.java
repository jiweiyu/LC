package leetcode;

public class InorderSuccessorInBST_285 {

    public TreeNode successor(TreeNode root, TreeNode p){
        if(root==null){
            return null;
        }

        if(root.val<=p.val){
            return successor(root.right, p);
        }else{
            TreeNode left = successor(root.left,p);
            return (left!=null) ? left:root;
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root!=null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            }
            else root = root.right;
        }
        return res;
    }
}
