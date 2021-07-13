package microsoft;

public class deleteNodeinBST_450 {

      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public TreeNode deleteNode_(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode rightSmallest = root.right;
            while (rightSmallest.left != null) rightSmallest = rightSmallest.left;
            rightSmallest.left = root.left;
            return root.right;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public TreeNode deleteNode_easyUnderstand(TreeNode root, int key)
    {

        TreeNode target = root, parent = null;

        //Search Node
        while (target != null && target.val != key)
        {
            parent = target;
            if (key > target.val) target = target.right;
            else target = target.left;
        }

        if (target == null) return root;  // not found


        // Case 1 : No children
        if(target.left==null && target.right==null)
        {
            if (parent == null) return null;
            if(target==parent.left) parent.left=null;
            else parent.right=null;
            return root;
        }

        // Case 2 : One Child

        // Case 2.1 : No right child
        if(target.right==null)
        {
            if (parent == null) return target.left; //If target node is root itself
            if (target == parent.left) parent.left = target.left;
            else parent.right = target.left;
            return root;
        }

        // Case 2.2 : No left child
        if(target.left==null)
        {
            if (parent == null) return target.right;
            if (target == parent.left) parent.left = target.right;
            else parent.right = target.right;
            return root;
        }

        // Case 3 : Both the child nodes present
        {
            /* Whenever we delete a node with two child then we replace that node with the
			   leftmost element from the right subtree because to hold the property of BST
			   all the element to the right of the new node will be greater than it and all the
			   left ones will be lesser than it
            */
            // Trace to the leftmost element in Right subtree
            TreeNode prev = target, p = target.right;
            while (p.left != null)
            {
                prev = p;
                p = p.left;
            }

            target.val = p.val;
            if (p == prev.left) prev.left = p.right;
            else prev.right = p.right;
            return root;
        }
    }

}
