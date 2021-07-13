package leetcode;
import java.util.*;
public class BinaryTreeZigzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = q.poll();
                list.add(cur.val);
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
            }
            res.add(new ArrayList<Integer>(list));
        }

        for(int i=1;i<res.size();i+=2){
            //List<Integer> level = res.get(i);
            Collections.reverse(res.get(i));
        }
        return res;
    }

}
