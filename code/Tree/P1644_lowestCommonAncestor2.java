package binaryTree;

public class P1644_lowestCommonAncestor2 {
	//时间n
	//空间栈空间 n
	
	private TreeNode ans = null;
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		dfs(root, p, q);
		return ans;
	}
	
	private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}
		
		boolean l = dfs(root.left, p, q);
		boolean r = dfs(root.right, p, q);
		
		if ((l && r) || ((l || r) && (root == p || root == q))) {
			ans = root;
		}
		return (l || r) || (root == p) || (root == q);
	}
}
