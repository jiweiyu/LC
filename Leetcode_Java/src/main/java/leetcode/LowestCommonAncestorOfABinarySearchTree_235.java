package leetcode;

public class LowestCommonAncestorOfABinarySearchTree_235 {

    //O(N), O(N)
    public TreeNode lowestCommonAncestor_recursive(TreeNode root, TreeNode p, TreeNode q) {
        int parentVal = root.val;

        int pVal = p.val;
        int qVal = q.val;

        if(pVal > parentVal && qVal > parentVal){
            return lowestCommonAncestor_recursive(root.right, p, q);
        }else if(pVal < parentVal && qVal < parentVal){
            return lowestCommonAncestor_recursive(root.left, p, q);
        }else{
            return root;
        }
    }


    public TreeNode lowestCommonAncestor_iterative(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode node = root;

        while(node!=null){
            int parentVal = node.val;
            if(pVal > parentVal && qVal > parentVal){
                node = node.right;
            }else if(pVal < parentVal && qVal < parentVal){
                node = node.left;
            }else{
                return node;
            }
        }
        return null;
    }
}
