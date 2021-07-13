package leetcode;

public class ClosestBinarySearchTreeValue_270 {
    public int closestValue(TreeNode root, double target) {
        float gap = 0;
        float min_gap = (float)target - root.val;
        TreeNode res = root;
        while(root != null){
            gap = (float)target - root.val;
            System.out.println("current node: " + root.val + ", gap: " + gap);
            if(Math.abs(gap) < Math.abs(min_gap)){
                min_gap = gap;
                res = root;
            }
            if(gap > 0) {
                root = root.right;
            }
            else if(gap < 0) {
                root = root.left;
            }
            else {
                res = root;
                break;
            }

        }
        return res.val;
    }
}
