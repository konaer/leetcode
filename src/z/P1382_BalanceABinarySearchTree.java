package z;

import java.util.List;

public class P1382_BalanceABinarySearchTree {
	//time n
	//space between n and logn
	List<Integer> list = new ArrayList<>();
	
	public TreeNode balanceBST(TreeNode root) {
		inorder(root);
		return dfs(0, list.size() - 1);
    }
	
	private TreeNode dfs(int l, int r) {
		if (l > r) {
			return null;
		}
		
		int mid = l + (r - l) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = dfs(l, mid - 1);
		root.right = dfs(mid + 1, r);
		return root;
	}
	
	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
}
