package leetcode;
import java.util.*;
public class FindLeavesOfBinaryTree_366 {

    //O(N), O(N)
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode node, List<List<Integer>> res){
        if(null==node)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if(res.size()<level+1)  res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }

    //remove the leaf nodes
    public List<List<Integer>> findLeaves_(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        while(root != null){
            List<Integer> tempList = new LinkedList<>();
            root = backtrack(root,tempList);
            list.add(tempList);
        }
        return list;
    }
    private TreeNode backtrack(TreeNode root, List<Integer> list){
        if(root == null) return null;
        TreeNode left = backtrack(root.left,list);             //postorder: left,right,root
        TreeNode right = backtrack(root.right,list);
        if(root.left == null && root.right == null) {
            list.add(root.val);
            return null;                                        //return null when reach leaf
        }
        root.left = left;                                       //delete left leaf
        root.right = right;                                     //delete right leaf
        return root;
    }
}
