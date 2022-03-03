package dp;

public class P337_HouseRobber3 {
	//time traversal n
	//space  stack n
	public int rob(TreeNode root) {
		int[] ans = dfs(root);
		return Math.max(ans[0], ans[1]);
    }
	
	private int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[] {0, 0};
		}
		
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		int rob = root.val + left[1] + right[1];
		int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return new int[] {rob, notRob};
	}
}
