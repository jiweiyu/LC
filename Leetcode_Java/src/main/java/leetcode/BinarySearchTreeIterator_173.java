package leetcode;

import java.util.Stack;

public class BinarySearchTreeIterator_173 {

    private final Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator_173(TreeNode root){
        pushAll(root);
    }

    private void pushAll(TreeNode node){
        for(;node!=null;stack.push(node),node=node.left);
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }

    public int next(){
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
}
