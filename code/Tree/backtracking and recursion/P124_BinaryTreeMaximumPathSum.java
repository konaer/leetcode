package binaryTree;

public class P124_BinaryTreeMaximumPathSum {
	//时间n
	//空间最差是n
	int ans = Integer.MIN_VALUE;
	
	public int maxPathSum(TreeNode root) {
		dfs(root);
		return ans;
    }
	
	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int l = Math.max(dfs(root.left), 0);
		int r = Math.max(dfs(root.right), 0);
		
		int sum = l + r + root.val;
		ans = Math.max(ans, sum);
		
		return Math.max(l, r) + root.val;
	}
}
