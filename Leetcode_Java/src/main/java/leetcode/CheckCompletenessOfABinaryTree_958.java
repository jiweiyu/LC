package leetcode;
import java.util.*;
public class CheckCompletenessOfABinaryTree_958 {

    //Time O(N), Space O(N)
    public boolean isCompleteTree_bfs(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }

    //Time O(N), Space O(height)
    public boolean isCompleteTree_dfs(TreeNode root) {
        return dfs(root) >= 0;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        if ((l & (l + 1)) == 0 && l / 2 <= r && r <= l)
            return l + r + 1;
        if ((r & (r + 1)) == 0 && r <= l && l <= r * 2 + 1)
            return l + r + 1;
        return -1 ;
    }
}
