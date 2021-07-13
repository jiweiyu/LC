package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthOfBinaryTree_662 {

    //DFS
    public int widthOfBinaryTree_dfs(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    //BFS MLE
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> next = new ArrayList<>();
        next.add(root);
        int max = 1;

        while(next.size()!=0){
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0 ;i<next.size(); i++){
                TreeNode cur = next.get(i);
                if(cur==null){
                    list.add(null);
                    list.add(null);
                }else{
                    list.add(cur.left);
                    list.add(cur.right);
                }
            }
            list = check(list);
            max = Math.max(max, list.size());
            next = list;

        }
        return max;

    }

    public List<TreeNode> check(List<TreeNode> list){
        List<TreeNode> res = new ArrayList<>();
        if(list == null) return res;
        int i = 0, j = list.size()-1;
        while(i<=j && list.get(i) == null){
            i++;
        }
        while(i<=j && list.get(j) == null){
            j--;
        }


        for(; i<=j; i++){
            res.add(list.get(i));
        }

        return res;
    }
}
