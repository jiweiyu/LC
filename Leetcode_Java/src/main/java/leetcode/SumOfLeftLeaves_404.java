package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves_404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null || root.left==null && root.right==null){
            return 0;
        }
        int res = 0;
        Queue<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while(!list.isEmpty()){
            TreeNode node = list.poll();
            System.out.println(node.val);
            if(node.left!=null && node.left.left==null && node.left.right==null){
                res+=node.left.val;
            }
            if(node.left!=null){
                list.offer(node.left);
            }
            if(node.right!=null){
                list.offer(node.right);
            }
        }
        return res;
    }
}
