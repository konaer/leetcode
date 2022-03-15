
public class P1372_LongestZigZagPathinaBinaryTree {
	//time n
	//space h
	int ans = 0;
	
	public int longestZigZag(TreeNode root) {
		dfs(root);
		return ans - 1;
    }
	
	private int[] dfs(TreeNode root) {
		int[] res = new int[2];
		
		if (root == null) {
			return res;
		}
		
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		res[0] = left[1] + 1;
		res[1] = right[0] + 1;
		ans = Math.max(ans, Math.max(res[0], res[1]));
		return res;
	}
}
