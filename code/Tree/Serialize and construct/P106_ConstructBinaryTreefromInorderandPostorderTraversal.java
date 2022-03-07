package z;

public class P106_ConstructBinaryTreefromInorderandPostorderTraversal {
	//time n
	//space n
	Map<Integer, Integer> map = new HashMap<>();
    int index;
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		
		int n = postorder.length;
        index = n - 1;
		if (n == 0) {
			return null;
		}
		
		for (int i = 0; i < n; i++) {
			map.put(inorder[i], i);
		}
		
		return dfs(inorder, postorder, 0, n - 1);		
    }
	
	private TreeNode dfs(int[] in, int[] post, int l, int r) {
		if (l > r) {
			return null;
		}
		
		TreeNode root = new TreeNode(post[index--]);
		int i = map.get(root.val);
		root.right = dfs(in, post, i + 1, r);
		root.left = dfs(in, post, l, i - 1);
		return root;
	}
}
