package leetcode;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees_1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<Integer>();
        printTree(root1, list1);
        printTree(root2, list2);

        int l1 = list1.size(), l2 = list2.size();
        int i1 = 0, i2 = 0;
        List<Integer> res = new ArrayList<Integer>();
        while(i1<l1 || i2<l2){
            if(i1<l1 && i2<l2 && list1.get(i1) <= list2.get(i2)){
                res.add(list1.get(i1++));
            }else if(i1<l1 && i2 >= l2){
                res.add(list1.get(i1++));
            }else{
                res.add(list2.get(i2++));
            }
        }
        return res;
    }

    private void printTree(TreeNode root, List<Integer> list){
        if(root==null) return;
        printTree(root.left, list);
        list.add(root.val);
        printTree(root.right, list);
    }
}
