package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode_116 {

    public Node connect(Node root) {
        if(root==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int level_size = queue.size();
            Node pre = queue.poll();
            //System.out.println("pre:"+pre.val);
            if(pre.left!=null){
                queue.add(pre.left);
                queue.add(pre.right);
            }
            for(int i=1;i<level_size;i++){
                Node cur = queue.poll();
                //System.out.println("cur:"+cur.val);
                if(cur.left!=null){
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
                pre.next = cur;
                pre = cur;

            }
            pre.next = null;
        }
        return root;
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
