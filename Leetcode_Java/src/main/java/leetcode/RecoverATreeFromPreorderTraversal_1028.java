package leetcode;

import java.util.Stack;

public class RecoverATreeFromPreorderTraversal_1028 {

    public TreeNode recoverFromPreorder(String S){
        int level, val;
        Stack<TreeNode> stack = new Stack<>();
        for(int i=0;i<S.length();){
            for(level=0;S.charAt(i)=='-';i++){
                level++;
            }
            for(val=0;i<S.length()&&S.charAt(i)!='-';i++){
                val = val*10 + (S.charAt(i)-'0');
            }
            while(stack.size()>level){
                stack.pop();
            }
            TreeNode node = new TreeNode(val);
            if(!stack.isEmpty()){
                if(stack.peek().left == null){
                    stack.peek().left = node;
                }else{
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        while(stack.size()>1){
            stack.pop();
        }
        return stack.pop();
    }

    //recursion
    int index = 0;
    public TreeNode recoverFromPreorder_recursive(String S){
        return helper(S, 0);
    }

    public TreeNode helper(String s, int depth){
        int numDash = 0;
        while(index + numDash < s.length() && s.charAt(index+numDash)=='-'){
            numDash++;
        }
        if(numDash!=depth) return null;
        int next = index+numDash;
        while(next < s.length() && s.charAt(next)!='-'){
            next++;
        }
        int val = Integer.parseInt(s.substring(index+numDash),next);
        index = next;
        TreeNode root = new TreeNode(val);
        root.left = helper(s,depth+1);
        root.right = helper(s, depth+1);
        return root;
    }
}
