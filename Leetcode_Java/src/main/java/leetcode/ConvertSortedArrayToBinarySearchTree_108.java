package leetcode;

public class ConvertSortedArrayToBinarySearchTree_108 {

    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    //O(N), O(N)
    public TreeNode helper(int left, int right){
        if(left > right) return null;

        int p = (left + right) / 2;
        //to start with right middle node
        //if((left + right) %2 == 1) p++;

        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p-1);
        root.right = helper(p+1, right);
        return root;
    }
}
