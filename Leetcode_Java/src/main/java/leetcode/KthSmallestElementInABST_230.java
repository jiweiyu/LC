package leetcode;

import java.util.*;

public class KthSmallestElementInABST_230 {

    //time O(N), space O(N)
    public int kthSmallest_Recursion(TreeNode root, int k) {
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k-1);
    }

    public ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr){
        if(root == null){
            return arr;
        }
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }

    //time O(H + k), space O(N + k)- worst, O(logN + k) - ave
    public int kthSmallest_Iteration(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root != null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0) return root.val;
            root = root.right;
        }
    }
}
