package leetcode;

import java.util.*;

public class LowestCommonAncestorOfABinaryTree_236 {

    private TreeNode ans;

    public LowestCommonAncestorOfABinaryTree_236(){
        this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q){
        if(currentNode == null){
            return false;
        }

        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;

        if(mid+left+right>= 2){
            this.ans = currentNode;
        }
        return (mid+left+right > 0);
    }

    public TreeNode lowestCommonAncestor_recusive(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }


    //iterate with parent pointers

    public TreeNode lowestCommonAncestor_iterate(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode node = stack.pop();
            if(node.left != null){
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if(node.right != null){
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p = parent.get(p);
        }

        while(!ancestors.contains(p)){
            q = parent.get(q);
        }

        return q;

    }

    //easy to understand
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

}
