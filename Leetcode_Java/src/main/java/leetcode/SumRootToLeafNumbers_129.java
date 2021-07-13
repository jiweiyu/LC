package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers_129 {

    //O(N)
    //O(h)
    public int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        int res = 0;
        for(int a : list){
            res += a;
        }
        return res;
    }

    public void helper(TreeNode root, int curr, List<Integer> list){

        if(root.left == null && root.right == null){
            list.add(curr*10+root.val);
            return;
        }
        if(root.left != null) helper(root.left, curr*10 + root.val, list);
        if(root.right != null) helper(root.right, curr*10 + root.val, list);
    }

}
