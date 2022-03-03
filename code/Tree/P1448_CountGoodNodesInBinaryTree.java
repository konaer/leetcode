package binaryTree;

public class P1448_CountGoodNodesInBinaryTree {
	public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
	
	private int dfs(TreeNode root, int max) {
		if (root == null) {
			return 0;
		}
		
		int valid = 0;
		if (root.val >= max) {
			max = root.val;
			valid = 1;
		} 
		
		int l = dfs(root.left, max);
		int r = dfs(root.right, max);
		return l + r + valid;
	}
}
