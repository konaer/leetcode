package binaryTree;

public class P701_InsertIntoABinarySearchTree {
	
//	public TreeNode insertIntoBST(TreeNode root, int val) {
//        if (root == null) {
//            return new TreeNode(val);
//        }
//
//        if (root.val > val) {
//            root.left = insertIntoBST(root.left, val);
//        } else {
//            root.right = insertIntoBST(root.right, val);
//        }
//        return root;
//    }
	
	//非递归解法
	public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                    break;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return root;
    }
}
