package leetcode;

public class DiameterOfBinaryTree_543 {

    //O(n)
    int ans;
    public int diameterOfBinaryTree_DFS(TreeNode root){
        ans = 0;
        depth(root);
        return ans;
    }

    public int depth(TreeNode node){
        if(node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, L+R);
        return Math.max(L, R) + 1;
    }

}
