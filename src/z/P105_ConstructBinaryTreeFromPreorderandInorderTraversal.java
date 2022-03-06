package z;
import java.util.Map;

public class P105_ConstructBinaryTreeFromPreorderandInorderTraversal {
	//time n
	//space n
	int i = 0;
	Map<Integer, Integer> map = new HashMap<>();
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0) {
			return null;
		}
		
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		
		return dfs(preorder, inorder, 0, inorder.length - 1);
    }
	
	private TreeNode dfs(int[] pre, int[] in, int l, int r) {
		if (l > r) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[i++]);
		int index = map.get(root.val);
		root.left = dfs(pre, in, l, index - 1);
		root.right = dfs(pre, in, index + 1, r);
		return root;
	}
}
