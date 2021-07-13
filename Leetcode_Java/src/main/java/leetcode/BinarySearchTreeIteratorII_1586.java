package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIteratorII_1586 {
    List<Integer> inorder = new ArrayList<>();
    int index = -1;

    public BinarySearchTreeIteratorII_1586(TreeNode root) {
        inOrder(root);
        //System.out.println(inorder.size());
        //index = 0;
    }

    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        inorder.add(root.val);
        inOrder(root.right);
    }

    public boolean hasNext() {
        //System.out.println("hasnext , cur ind: "+index + "," + inorder.size());
        return index+1<inorder.size();
    }

    public int next() {
        //System.out.println("next , cur ind: "+index);
        if(index+1<inorder.size()) return inorder.get(++index);
        else return inorder.get(inorder.size()-1);
    }

    public boolean hasPrev() {
        return index>0;
    }

    public int prev() {
        if(index-1>=0) return inorder.get(--index);
        else return inorder.get(0);
    }
}
