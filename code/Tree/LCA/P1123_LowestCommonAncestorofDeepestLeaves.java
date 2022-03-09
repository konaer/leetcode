package z;

public class P1123_LowestCommonAncestorofDeepestLeaves {
	//time n
	//space n
	public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = dfs(root, 0);
        return p.node;
    }

    private Pair dfs(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(root, depth);
        }

        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if (left.depth == right.depth) {
            return new Pair(root, left.depth);
        } else {
            return left.depth > right.depth ? left : right;
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
