package leetcode;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList_426 {

    class Node
    {
        int val;
        Node left;
        Node right;
        Node(int _val, Node _left, Node _right){
            this.val = _val;
            this.left = _left;
            this.right = _right;
        }
    }

    Node prev = null;

    public Node treeToDoublyList(Node root){
        if(root==null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        //prev is the last node
        //dummy.right is the first node
        prev.right = dummy.right;
        dummy.right.left=prev;
        return dummy.right;
    }

    private void helper(Node cur){
        if(cur == null) return;
        helper(cur.left);
        prev.right=cur;
        cur.left=prev;
        prev = cur;
        helper(cur.right);
    }


}
