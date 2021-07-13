package leetcode;

import java.util.*;

public class AverageOfLevelsInBinaryTree_637 {

    //O(n), O(h)
    public List<Double> averageOfLevels_DFS(TreeNode root) {
        List<Integer> count = new ArrayList<>();
        List<Double> res = new ArrayList<>();
        average(root, 0, res, count);

        for(int i = 0; i < res.size(); i++){
            res.set(i, res.get(i)/count.get(i));
        }

        return res;
    }

    public void average(TreeNode t, int i, List<Double> sum, List<Integer> count){
        if(t == null) return;
        if(i < sum.size()){
            sum.set(i, sum.get(i)+t.val);
            count.set(i, count.get(i) +1);
        }else{
            sum.add(1.0* t.val);
            count.add(1);
        }
        average(t.left, i+1, sum, count);
        average(t.right, i+1, sum, count);

    }

    //O(n), O(m), m refers to the maximum of nodes at any level in the input tree
    public List<Double> averageOfLevels_BFS(TreeNode root) {

        List<Double> res  = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            long sum = 0;
            long count = queue.size();
            for(long i = 0;i<count;i++){
                TreeNode n = queue.remove();
                sum += n.val;
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
            res.add(sum * 1.0/count);
        }
        return res;
    }
}
