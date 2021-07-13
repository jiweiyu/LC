package leetcode;

import java.util.*;
public class SerializeAndDeserializeBinaryTree_297 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return serial(new StringBuilder(), root).toString();
        }

        private StringBuilder serial(StringBuilder str, TreeNode root){
            if(root == null) return str.append("#").append(",");
            str.append(root.val).append(",");
            serial(str, root.left);
            serial(str, root.right);
            return str;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return deserial(new LinkedList<>(Arrays.asList(data.split(","))));
        }

        private TreeNode deserial(Queue<String> q){
            String val = q.poll();
            if("#".equals(val)) return null;
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = deserial(q);
            root.right = deserial(q);
            return root;
        }

        //BFS
        public String serialize_bfs(TreeNode root) {
            if (root == null) return "";
            Queue<TreeNode> q = new LinkedList<>();
            StringBuilder res = new StringBuilder();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node == null) {
                    res.append("n ");
                    continue;
                }
                res.append(node.val + " ");
                q.add(node.left);
                q.add(node.right);
            }
            return res.toString();
        }

        public TreeNode deserialize_bfs(String data) {
            if (data == "") return null;
            Queue<TreeNode> q = new LinkedList<>();
            String[] values = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            q.add(root);
            for (int i = 1; i < values.length; i++) {
                TreeNode parent = q.poll();
                if (!values[i].equals("n")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    q.add(left);
                }
                if (!values[++i].equals("n")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    q.add(right);
                }
            }
            return root;
        }

}
