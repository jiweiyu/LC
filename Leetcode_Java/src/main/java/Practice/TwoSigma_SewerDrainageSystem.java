package Practice;

/*
具体是说一个sewer drainage system组成的二叉树，每个节点标记了<节点号码>/<水流数量>。 然后根据分支算出最小的水流数量差。例如：
分支一：节点号是（0，2，5） -> 水流数量是 1 + 2 + 1 = 4
分支二：节点号是（1, 3, 4） -> 水流数量是 2 + 1 + 1 = 4
所以结果应该输出 4 - 4 = 0

分支二是从节点一开始的，因为母节点0已经在分支一里面了，所以不能算在另外一个分支里。
 */
public class TwoSigma_SewerDrainageSystem {

    static class Node{
        Node left;
        Node right;
        int val;
        int flow;
        public Node(int val, int flow){
            this.val = val;
            this.flow = flow;
        }
        public Node(Node left, Node right, int val, int flow){
            this.left = left;
            this.right = right;
            this.val = val;
            this.flow = flow;
        }
    }

    static int res = Integer.MAX_VALUE;
    static int sum = 0;
    public static int getDiff(Node root){
        sum = getSum(root, 0);
        check(root);
        return res;
    }

    static void check(Node node){
        if(node.left != null) check(node.left);
        if(node.right != null) check(node.right);
        int cursum = getSum(node, 0);
        res = Math.min(sum-cursum, res);
    }

    static int getSum(Node node, int sum){
        if(node==null) return sum;
        int left = getSum(node.left, sum);
        int right = getSum(node.right, sum);
        return left+right+node.flow;
    }

    public static void main(String[] args){
        Node root = new Node(0, 1);
        Node node3 = new Node(3,1);
        Node node4 = new Node(4,1);
        Node node5 = new Node(5,1);
        Node node1 = new Node(node3, node4,1,2);
        Node node2 = new Node(null, node5,2,2);
        root.left = node1;
        root.right = node2;

        int res = getDiff(root);
        System.out.println(res);
    }
}
