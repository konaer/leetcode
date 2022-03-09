package binaryTree;

public class P1448_CountGoodNodesInBinaryTree {
	//time n
	//space logn
	int ans = 0;
	public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
	
	private void dfs(TreeNode root, int max) {
		if (root == null) {
			return;
		}
		
		if (root.val >= max) {
			max = root.val;
			ans++;
		} 
		
		dfs(root.left, max);
		dfs(root.right, max);
	}
}
