package leetcode;

import java.util.Stack;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    //O(n) time and O(n) space
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        return build(preorder, 0, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int [] preorder, int preLow, int[] inorder, int inLow, int inHigh){
        if(preLow>preorder.length-1 || inLow>inHigh) return null;
        TreeNode root = new TreeNode(preorder[preLow]);

        int inorderRoot = inLow;
        for(int i=inLow;i<=inHigh;i++){
            if(inorder[i]==root.val){ inorderRoot=i; break; }
        }

        int leftTreeLen = inorderRoot-inLow;
        root.left = build(preorder, preLow+1,  inorder, inLow, inorderRoot-1);
        root.right = build(preorder, preLow+leftTreeLen+1, inorder, inorderRoot+1, inHigh);
        return root;
    }

    //O(n) time and O(n) space
    public TreeNode buildTree_iterative(int[] inorder, int[] preorder){
        if(preorder.length == 0) return null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        for(int i = 1, j = 0; i <preorder.length; i++){
            if(cur.val != inorder[j]){
                cur.left = new TreeNode(preorder[i]);
                s.push(cur);
                cur = cur.left;
            }else{
                j++;
                while(!s.empty() && s.peek().val == inorder[j]){
                    cur = s.pop();
                    j++;
                }
                cur = cur.right = new TreeNode(preorder[i]);
            }
        }
        return root;
    }
}
