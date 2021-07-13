package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree_1382 {

    List<TreeNode> sortedArr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root){
        inorderTraverse(root);
        return sortedArrayToBST(0, sortedArr.size()-1);
    }

    public void inorderTraverse(TreeNode root){
        if(root==null)return;
        inorderTraverse(root.left);
        sortedArr.add(root);
        inorderTraverse(root.right);
    }

    public TreeNode sortedArrayToBST(int start, int end){
        if(start>end) return null;
        int mid = (start+end)/2;
        TreeNode root = sortedArr.get(mid);
        root.left = sortedArrayToBST(start,mid-1);
        root.right = sortedArrayToBST(mid+1,end);
        return root;
    }

}
