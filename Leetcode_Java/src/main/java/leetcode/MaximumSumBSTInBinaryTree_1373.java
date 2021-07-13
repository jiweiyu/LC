package leetcode;

public class MaximumSumBSTInBinaryTree_1373 {

    //post order, O(n), O(h)
    private final int maxSum_ = 0;
    public int maxSumBST_(TreeNode root) {
        postOrderTraverse(root);
        return maxSum;
    }
    private int[] postOrderTraverse(TreeNode root) {
        if (root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}; // {min, max, sum}, initialize min=MAX_VALUE, max=MIN_VALUE
        int[] left = postOrderTraverse(root.left);
        int[] right = postOrderTraverse(root.right);
        // The BST is the tree:
        if (!(     left != null             // the left subtree must be BST
                && right != null            // the right subtree must be BST
                && root.val > left[1]       // the root's key must greater than maximum keys of the left subtree
                && root.val < right[0]))    // the root's key must lower than minimum keys of the right subtree
            return null;
        int sum = root.val + left[2] + right[2]; // now it's a BST make `root` as root
        maxSum = Math.max(maxSum, sum);
        int min = Math.min(root.val, left[0]);
        int max = Math.max(root.val, right[1]);
        return new int[]{min, max, sum};
    }



    //
    static class NodeWrapper {
        final TreeNode node;
        int sum;
        int max;
        int min;
        boolean validBST = true;
        public NodeWrapper(TreeNode node) {
            this.node = node;
            this.sum = node.val;
            this.max = node.val;
            this.min = node.val;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root){
        findMaxSum(root);
        return maxSum;
    }

    public NodeWrapper findMaxSum(TreeNode root){
        if(root==null) return null;

        NodeWrapper leftTree = findMaxSum(root.left);
        NodeWrapper rightTree = findMaxSum(root.right);

        NodeWrapper curNode = new NodeWrapper(root);

        if(leftTree != null){
            curNode.sum += leftTree.sum;
            curNode.max = Math.max(leftTree.max, root.val);
            curNode.min = Math.min(leftTree.min, root.val);
            curNode.validBST = leftTree.validBST && leftTree.max<root.val;
        }

        if(rightTree != null){
            curNode.sum += rightTree.sum;
            curNode.max = Math.max(rightTree.max, root.val);
            curNode.min = Math.min(rightTree.min, root.val);
            curNode.validBST = rightTree.validBST && rightTree.min>root.val;
        }

        if(curNode.validBST){
            maxSum = Math.max(maxSum, curNode.sum);
        }
        return curNode;
    }
}
