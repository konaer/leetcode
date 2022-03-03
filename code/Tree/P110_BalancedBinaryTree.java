package binaryTree;

public class P110_BalancedBinaryTree {
	//时间n，一个自底而上的递归，每个点遍历了1遍
	//空间n， 递归最差n层，最好logn
	private final int NOT_BALANCED = -1;
	
	public boolean isBalanced(TreeNode root) {	
        return getHeight(root) != NOT_BALANCED;
    }
	
	private int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if (left == NOT_BALANCED || right == NOT_BALANCED || Math.abs(right - left) > 1) {
			return NOT_BALANCED;
		}
		return Math.max(left, right) + 1;
	}
}
