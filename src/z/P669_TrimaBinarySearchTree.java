package binaryTree;

public class P669_TrimaBinarySearchTree {
	//时间最差是遍历n
	//栈空间，最差是n
	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		}
		
		if (root.val < low) {
			root = trimBST(root.right, low, high);
		} else if (root.val > high) {
			root = trimBST(root.left, low, high);
		} else {
			root.left = trimBST(root.left, low, high);
			root.right = trimBST(root.right, low, high);	
		}
		return root;
	}
	
	//deep copy a tree
	public TreeNode copy(TreeNode root) {
		if (root == null) {
			return null;
		}
		
		TreeNode node = new TreeNode(root.val);
		node.left = copy(root.left);
		node.right = copy(root.right);
		return node;
	}
}
