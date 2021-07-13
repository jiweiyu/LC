package leetcode;
import java.util.*;
public class BinaryTreeRightSideView_199 {

    //recursive dfs
    //O(N)
    //O(H)
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }

    private void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth==result.size()){
            result.add(curr.val);
        }
        rightView(curr.right, result, currDepth+1);
        rightView(curr.left, result, currDepth+1);
    }
}
