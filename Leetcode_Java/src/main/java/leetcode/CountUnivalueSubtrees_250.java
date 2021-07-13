package leetcode;

public class CountUnivalueSubtrees_250 {

    public int countUniversalSubtrees(TreeNode root){
        if(root == null) return 0;
        int count = isUniversal(root) ? 1 : 0;
        return count + countUniversalSubtrees(root.left) + countUniversalSubtrees(root.right);
    }

    boolean isUniversal(TreeNode node){
        boolean b = true;
        if(node.left != null){
            b &= node.val == node.left.val;
            b &= isUniversal(node.left);
        }
        if(node.right != null){
            b &= node.val == node.right.val;
            b &= isUniversal(node.right);
        }
        return b;
    }

    ///
    private int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        help(root);
        return res;
    }

    private boolean help(TreeNode node){
        if(node==null) return true;
        boolean left = help(node.left);
        boolean right = help(node.right);
        if(left && right){
            if((node.left!=null && node.val!=node.left.val) ||
                    (node.right!=null && node.val!=node.right.val)){
                return false;
            }
            res++;
            return true;
        }
        return false;
    }

}
