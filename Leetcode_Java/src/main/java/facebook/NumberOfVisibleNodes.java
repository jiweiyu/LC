package facebook;

public class NumberOfVisibleNodes {

    class Node {
        int data;
        Node left;
        Node right;
        Node() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int visibleNodes(Node root) {
        // Write your code here
        if(root==null) return 0;
        int left = visibleNodes(root.left);
        int right = visibleNodes(root.right);
        return Math.max(left, right)+1;
    }
}
