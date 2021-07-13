package leetcode;


import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNodeII_117 {

    public Node connect_from116(Node root) {
        if(root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level_size = queue.size();
            Node pre = queue.poll();
            if(pre.left!=null){
                queue.add(pre.left);
            }
            if(pre.right!=null){
                queue.add(pre.right);
            }
            for(int i=1;i<level_size;i++){
                Node cur = queue.poll();
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
                pre.next = cur;
                pre = cur;

            }
            pre.next = null;
        }
        return root;
    }

    public TreeLinkNode connect_(TreeLinkNode root) {
        helper(root);
        return root;
    }
    public void helper(TreeLinkNode prevLevelLeftMost){
        if (prevLevelLeftMost==null){
            return;
        }
        // a dummy node
        TreeLinkNode firstNode = new TreeLinkNode();
        TreeLinkNode currentNode = firstNode;

        // prevLevelLeftMost is the first Node of previous level
        // basically, we use the previous level (with next ptr, the last level turned into a linkedlist) to guide the connection of this level

        while(prevLevelLeftMost!=null){
            if (prevLevelLeftMost.left!=null){
                currentNode.next = prevLevelLeftMost.left;
                currentNode = currentNode.next;
            }
            if (prevLevelLeftMost.right!=null){
                currentNode.next = prevLevelLeftMost.right;
                currentNode = currentNode.next;
            }
            prevLevelLeftMost = prevLevelLeftMost.next;
        }
        helper(firstNode.next);
    }

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curP = root;
        TreeLinkNode nextDummyHead = new TreeLinkNode(0);
        TreeLinkNode p = nextDummyHead;
        while (curP != null) {
            if (curP.left != null) {
                p.next = curP.left;
                p = p.next;
            }
            if (curP.right != null) {
                p.next = curP.right;
                p = p.next;
            }
            if (curP.next != null) {
                curP = curP.next;
            }
            else {
                curP = nextDummyHead.next;
                nextDummyHead.next = null;
                p = nextDummyHead;
            }
        }
    }

    class TreeLinkNode {
        public int val;
        public TreeLinkNode left;
        public TreeLinkNode right;
        public TreeLinkNode next;

        public TreeLinkNode() {}

        public TreeLinkNode(int _val) {
            val = _val;
        }

        public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
