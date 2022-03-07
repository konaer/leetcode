package z;

import java.util.Map;

public class P889_ConstructBinaryTreeTreeFromPreorderandPostorder {
	//time n
	//space n
	Map<Integer, Integer> map = new HashMap<>();
	int index;
	
	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		int n = post.length;
		if (n == 0) {
			return null;
		}
		
		for (int i = 0; i < n; i++) {
			map.put(post[i], i);
		}
		return dfs(pre, post, 0, n - 1);
    }
	
	private TreeNode dfs(int[] pre, int post[], int l, int r) {
		//注意这里的停止条件，因为这个l和r不符合中序遍历时的边界情况，所以要加上额外限制
		if (l > r || index >= pre.length) {
			return null;
		}
		
		TreeNode root = new TreeNode(pre[index++]);
		if (index == pre.length || l == r) {
			return root;
		}
		
		int i = map.get(pre[index]);
		root.left = dfs(pre, post, l, i);
		//这个地方别忘了r - 1， 减去已经使用了的最后一个，作为root了
		root.right = dfs(pre, post, i + 1, r - 1);
		return root;
	}
}
