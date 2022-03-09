package z;

public class P865_SmallestSubtreewithalltheDeepestNodes {
	//time n
	//space n
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		Pair p = dfs(root, 0);
		return p.node;
    }
	
	private Pair dfs(TreeNode root, int depth) {
		if (root == null) {
			return new Pair(root, depth);
		}
		
		Pair l = dfs(root.left, depth + 1);
		Pair r = dfs(root.right, depth + 1);
		if (l.depth == r.depth) {
			return new Pair(root, l.depth);
		} else {
			return l.depth > r.depth ? l : r;
		}
	}
	
	private class Pair {
		TreeNode node;
		int depth;
		
		public Pair(TreeNode node, int depth) {
			this.node = node;
			this.depth = depth;
		}
	}
}
