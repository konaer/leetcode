package z;

public class P1008_ConstructBinarySearchTreefromPreorderTraversal {
	//time n
	//space n
	int index = 0;
	
	public TreeNode bstFromPreorder(int[] preorder) {
		if (preorder.length == 0) {
			return null;
		}
		return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	
	private TreeNode dfs(int[] preorder, int low, int high) {
		if (index == preorder.length) {
			return null;
		}
		
		if (preorder[index] < low || preorder[index] > high) {
			return null;
		}
		
		TreeNode root = new TreeNode(preorder[index++]);
		root.left = dfs(preorder, low, root.val);
		root.right = dfs(preorder, root.val, high);
		return root;
	}
}
