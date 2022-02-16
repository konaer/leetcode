package binaryTree;

public class L596_MinimumSubtree {
	
	private TreeNode node = null;
	private int minSum = Integer.MAX_VALUE;
	
	public TreeNode findSubtree(TreeNode root) {
		getSum(root);
		return node;
    }
	
	private int getSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int sum = getSum(root.left) + getSum(root.right) + root.val;
		if (sum <= minSum) {
			minSum = sum;
			node = root;
		}
		return sum;
	}
}
