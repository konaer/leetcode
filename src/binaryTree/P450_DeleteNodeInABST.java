package binaryTree;

public class P450_DeleteNodeInABST {
	//时间logn, 从root到找到这个点用了H1，从这个点到替换用了H2
	//h1+h2正好等于深度
	
	//空间 树的高度，栈空间logn
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return root;
		}
		
		if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else {
			if (root.left == null && root.right == null) {
				//注意这里是root，而不是root.val
				root = null;
			} else if (root.right != null) {
				root.val = successor(root);
				root.right = deleteNode(root.right, root.val);
			} else {
				root.val = predecessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
    }
	
	private int successor(TreeNode root) {
		root = root.right;
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}
	
	private int predecessor(TreeNode root) {
		root = root.left;
		while (root.right != null) {
			root = root.right;
		}
        return root.val;
	}
}
