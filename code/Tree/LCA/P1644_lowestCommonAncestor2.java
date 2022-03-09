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
	

	//第二种
	int count = 0;
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		TreeNode node = dfs(root, p, q);
		return count == 2 ? node : null;
	}
	
	private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return root;
		}
		
		
		
		TreeNode left = dfs(root.left, p, q);
		TreeNode right = dfs(root.right, p, q);
		//这个放在后面是因为要计算count，如果放前面，return之后，就不更新count了
		if (root == p || root == q) {
			count++;
			return root;
		}
		
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}	
		return root; 
	}
	
}
