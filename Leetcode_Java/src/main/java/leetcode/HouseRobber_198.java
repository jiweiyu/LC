package leetcode;

public class HouseRobber_198 {

    public int rob_recursive_topdown(int[] nums) {
        return rob_recursive_topdown(nums, nums.length - 1);
    }
    private int rob_recursive_topdown(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }
        return Math.max(rob_recursive_topdown(nums, i - 2) + nums[i], rob_recursive_topdown(nums, i - 1));
    }

    public int rob_iterative_bottomup(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num : nums) {
            int tmp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = tmp;
        }
        return prev1;
    }


}
