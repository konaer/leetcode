package binaryTree;

public class P235_LowestCommonAncestorofaBinarySearchTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode node = root;
		while (node != null) {
			if (node.val > p.val && node.val > q.val) {
				node = node.left;
			} else if (node.val < p.val && node.val < q.val) {
				node = node.right;
			} else {
				return node;
			}
		}
		return null;
	}
}
