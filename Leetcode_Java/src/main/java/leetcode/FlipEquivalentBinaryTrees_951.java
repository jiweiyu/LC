package leetcode;
import java.util.*;
public class FlipEquivalentBinaryTrees_951 {

    public boolean flipEquiv_DFS_recursion(TreeNode root1, TreeNode root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return ( flipEquiv_DFS_recursion(root1.left, root2.left) && flipEquiv_DFS_recursion(root1.right, root2.right) )
                || ( flipEquiv_DFS_recursion(root1.left, root2.right) && flipEquiv_DFS_recursion(root1.right, root2.left) );
    }

    public boolean flipEquiv_DFS_iterative(TreeNode root1, TreeNode root2){
        Stack<TreeNode> stk1 = new Stack<>(), stk2 = new Stack<>();
        stk1.push(root1);
        stk2.push(root2);
        while(!stk1.isEmpty() && !stk2.isEmpty()){
            TreeNode n1 = stk1.pop(), n2 = stk2.pop();
            if(n1==null && n2==null){
                continue;
            }else if(n1==null || n2==null || n1.val!=n2.val){
                return false;
            }
            if(n1.left==n2.left || n1.left!=null && n2.left!=null && n1.left.val==n2.left.val){
                stk1.addAll(Arrays.asList(n1.left,n1.right));
            }else{
                stk1.addAll(Arrays.asList(n1.right,n1.left));
            }
            stk2.addAll(Arrays.asList(n2.left,n2.right));
        }
        return stk1.isEmpty()&&stk2.isEmpty();
    }

    public boolean flipEquiv_BFS_iterative(TreeNode root1, TreeNode root2) {
        Queue<TreeNode> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode n1 = q1.poll(), n2 = q2.poll();
            if(n1==null || n2==null){
                if(n1!=n2) return false;
                else continue;
            }
            if(n1.val!=n2.val){
                return false;
            }
            if(n1.left==n2.left || n1.left!=null && n2.left!=null && n1.left.val==n2.left.val){
                q1.addAll(Arrays.asList(n1.left,n1.right));
            }else{
                q1.addAll(Arrays.asList(n1.right,n1.left));
            }
            q2.addAll(Arrays.asList(n2.left,n2.right));
        }
        return q1.isEmpty() && q2.isEmpty();
    }
}
