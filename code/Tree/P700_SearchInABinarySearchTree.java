package binaryTree;

public class P700_SearchInABinarySearchTree {
	public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            searchBST(root.left, val);
        } else {
            searchBST(root.right, val);
        }
        return null;

    }
}
