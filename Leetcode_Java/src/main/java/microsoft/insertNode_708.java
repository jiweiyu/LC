package microsoft;

import java.io.*;

class insertNode_708 {

    public static void main(String[] arg){
        Node_708 node1 = new Node_708(1, null);
        Node_708 node2 = new Node_708(2, null);
        Node_708 node3 = new Node_708(3, null);
        Node_708 node4 = new Node_708(4, null);

        //1 > 3 > 4 > 1
        node1.next = node3;
        node3.next = node4;
        node4.next = node1;

        Node_708 x = insert(node1, 2);

        System.out.println(x.next.val);

    }

    public static Node_708 insert(Node_708 start, int x) {
        if (start == null) {
            Node_708 node = new Node_708(x, null);
            node.next = node;
            return node;
        }

        Node_708 cur = start;
        while (true) {
            if (cur.val < cur.next.val) {
                if (cur.val <= x && x <= cur.next.val) {
                    insertAfter(cur, x);
                    break;
                }
            } else if (cur.val > cur.next.val) {
                if (cur.val >= x && x >= cur.next.val) {
                    insertAfter(cur, x);
                    break;
                }
            } else {
                if (cur.next == start) {
                    insertAfter(cur, x);
                }
            }
            cur = cur.next;
        }
        return start;

    }

    private static void insertAfter(Node_708 cur, int x) {
        cur.next = new Node_708(x, cur.next);
    }
}

class Node_708 {
    int val;
    Node_708 next;

    Node_708(int val, Node_708 next){
        this.val = val;
        this.next = next;
    }
}