package microsoft;

import java.util.ArrayList;
import java.util.List;

public class printBinaryTree_655 {

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            result.add(list);
        }
        helper(result, root, 0, 0, width);
        return result;
    }
    private void helper(List<List<String>> result, TreeNode node, int level, int left, int right) {
        if (node == null) return;
        int index = -1;
        index = left + (right - left) / 2;
        result.get(level).set(index, String.valueOf(node.val));
        helper(result, node.left, level + 1, left, index - 1);
        helper(result, node.right, level + 1, index + 1, right);
    }

    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = 1 + getHeight(node.left);
        int right = 1 + getHeight(node.right);
        return Math.max(left, right);
    }
}
