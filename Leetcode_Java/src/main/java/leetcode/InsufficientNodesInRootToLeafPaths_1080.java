package leetcode;

public class InsufficientNodesInRootToLeafPaths_1080 {

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return calculateSum(root,limit);
    }

    public TreeNode calculateSum(TreeNode node ,int limit){
        if(node==null) return null;
        if(node.left==null && node.right == null){
            if(node.val<limit) return null;
            if(node.val>=limit) return node;
        }
        if(node.left!=null){
            node.left = calculateSum(node.left, limit-node.val);
        }
        if(node.right!=null){
            node.right = calculateSum(node.right, limit-node.val);
        }
        if(node.left==null && node.right==null){
            return null;
        }
        return node;
    }
}
