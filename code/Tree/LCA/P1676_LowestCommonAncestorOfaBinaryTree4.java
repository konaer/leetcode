package z;

public class P1676_LowestCommonAncestorOfaBinaryTree4 {
	//time n
	//space n
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
		Set<TreeNode> set = new HashSet<>();
		for (TreeNode node : nodes) {
			set.add(node);
		}
		return dfs(root, set);
    }
	
	private TreeNode dfs(TreeNode root, Set<TreeNode> set) {
		if (root == null) {
			return root;
		}
		
		if (set.contains(root)) {
			return root;
		}
		
		TreeNode left = dfs(root.left, set);
		TreeNode right = dfs(root.right, set);
		
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		
		return root;
	}
	
	
}
