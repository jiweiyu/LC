package leetcode;

import java.util.*;

public class MergeTwoBinaryTrees_617 {


    //O(m), O(m), m is total nodes
    public TreeNode mergeTrees_resrusion(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        if(t2 == null){
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees_resrusion(t1.left,t2.left);
        t1.right = mergeTrees_resrusion(t1.right, t2.right);
        return t1;

    }

    //O(n), O(n),n refers to the smaller of the number of nodes in the two trees.
    public TreeNode mergeTrees_iterative(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});
        while(!stack.isEmpty()){
            TreeNode[] t = stack.pop();
            if(t[1] == null) continue;
            t[0].val += t[1].val;
            if(t[0].left == null){
                t[0].left = t[1].left;
            }else{
                stack.push(new TreeNode[]{t[0].left, t[1].left});
            }
            if(t[0].right == null){
                t[0].right = t[1].right;
            }else{
                stack.push(new TreeNode[]{t[0].right, t[1].right});
            }
        }
        return t1;
    }
}
