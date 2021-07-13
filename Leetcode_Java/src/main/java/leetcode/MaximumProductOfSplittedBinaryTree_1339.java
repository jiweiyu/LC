package leetcode;

public class MaximumProductOfSplittedBinaryTree_1339 {

    static long sum;
    static long maxProd;

    public int maxProduct(TreeNode root){
        sum = 0;
        maxProd = 0;
        dfs(root);
        long rootProd = checkMax(root);
        return (int)(maxProd % ((int) Math.pow(10,9)+7));
    }

    public static void dfs(TreeNode root){
        if(root==null) return;
        sum+=root.val;
        dfs(root.left);
        dfs(root.right);
    }

    public static long checkMax(TreeNode root){
        if(root==null) return 0;
        long l = checkMax(root.left);
        long r = checkMax(root.right);
        maxProd = Math.max(maxProd, (l+r+root.val)*(sum-l-r-root.val));
        return l+r+root.val;
    }
}
