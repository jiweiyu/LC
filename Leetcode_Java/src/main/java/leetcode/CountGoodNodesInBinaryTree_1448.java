package leetcode;

public class CountGoodNodesInBinaryTree_1448 {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int ma){
        if(root == null) return 0;
        int res = root.val >= ma ? 1 : 0;
        res += goodNodes(root.left, Math.max(root.val, ma));
        res += goodNodes(root.right, Math.max(root.val, ma));
        return res;
    }
}
