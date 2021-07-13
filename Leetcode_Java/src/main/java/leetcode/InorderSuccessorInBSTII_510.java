package leetcode;

class Node_510 {
    public int val;
    public Node_510 left;
    public Node_510 right;
    public Node_510 parent;
}

public class InorderSuccessorInBSTII_510 {

    public Node_510 inorderSuccessor_(Node_510 x) {
        if(x == null) return null;

        if(x.right != null) {
            x = x.right;

            while(x != null && x.left != null) {
                x = x.left;
            }

            return x;
        }

        while(x != null)
        {
            if(x.parent == null)
                return null;

            if(x.parent.left == x)
                return x.parent;

            else {
                x = x.parent;
            }

        }

        return x;
    }

    public Node_510 inorderSuccessor(Node_510 x) {
        if(x.right==null){
            Node_510 result = x.parent;
            while(result != null && result.val<x.val){
                result = result.parent;
            }
            return result;
        }else{
            Node_510 result = x.right;
            while(result.left!=null){
                result = result.left;
            }
            return result;
        }

    }
}
