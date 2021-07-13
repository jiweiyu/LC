package leetcode;

import jdk.nashorn.api.tree.Tree;

public class InsertIntoABinarySearchTree_701 {

    //time O(H), space O(logN)
    public TreeNode insertIntoBST_recursion(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(val > root.val){
            root.right = insertIntoBST_recursion(root.right, val);
        }else{
            root.left = insertIntoBST_recursion(root.left, val);
        }
        return root;
    }

    //time O(H), space O(logN)
    public TreeNode insertIntoBST_interation(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode node = new TreeNode(val);

        while(node != null){
            if(val > node.val){
                if(node.right == null){
                    node.right = new TreeNode(val);
                    return root;
                }else{
                    node = node.right;
                }
            }
            else{
                if(node.left == null){
                    node.left = new TreeNode(val);
                    return root;
                }else{
                    node = node.left;
                }
            }
            return new TreeNode(val);
        }

        return root;
    }
}
