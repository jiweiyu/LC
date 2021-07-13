package leetcode;

public class SecondMinimumNodeInaBinaryTree_671 {

    public int findSecondMinimumValue_(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }

        int left = root.left.val;
        int right = root.right.val;

        // if value same as root value, need to find the next candidate
        if (root.left.val == root.val) {
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val) {
            right = findSecondMinimumValue(root.right);
        }

        if (left != -1 && right != -1) {
            return Math.min(left, right);
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    //O(n), O(n)

    int min1;
    long ans = Long.MAX_VALUE;

    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        dfs(root);
        return ans < Long.MAX_VALUE ? (int) ans: -1;
    }

    public void dfs(TreeNode root){
        if(root != null){
            if(min1 < root.val && root.val < ans){
                ans = root.val;
            }else if(min1 == root.val){
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}
