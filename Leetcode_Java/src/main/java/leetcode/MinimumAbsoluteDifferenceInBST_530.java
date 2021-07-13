package leetcode;
import java.util.*;
public class MinimumAbsoluteDifferenceInBST_530 {


    //time complexity O(N), space complexity O(1)
    int min = Integer.MAX_VALUE;
    Integer prev = null;

    public int getMinimumDifference_InOrder(TreeNode root) {
        if(root == null) return min;

        getMinimumDifference_InOrder(root.left);

        if(prev != null){
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference_InOrder(root.right);
        return min;
    }

    //if it's not a BST
    //time complexity O(NlgN), space complexity O(N)
    //TreeSet is one of the most important implementations of the SortedSet interface in Java that uses a Tree for storage.
    TreeSet<Integer> set = new TreeSet<>();

    public int getMinimumDifference_PreOrder(TreeNode root) {
        if(root == null) return min;

        if(!set.isEmpty()){
            if(set.floor(root.val) != null){
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if(set.ceiling(root.val) != null){
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }
        set.add(root.val);
        getMinimumDifference_PreOrder(root.left);
        getMinimumDifference_PreOrder(root.right);

        return min;
    }
}
