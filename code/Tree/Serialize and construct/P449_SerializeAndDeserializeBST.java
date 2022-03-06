package z;

import java.util.List;

public class P449_SerializeAndDeserializeBST {
	//time n
	//space n
	public String serialize(TreeNode root) {
		List<String> list = new ArrayList<>();
		dfs(root, list);
		return String.join(",", list);
	}
	
	private void dfs(TreeNode root, List<String> list) {
		if (root == null) {
			return;
		}
		list.add(String.valueOf(root.val));
		dfs(root.left, list);
		dfs(root.right, list);
	}

	public TreeNode deserialize(String data) {
		if (data.length() == 0) {
			return null;
		}
		
		Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
		return dfs2(queue, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private TreeNode dfs2(Queue<String> queue, int low, int high) {
		//之所以要加这个，是因为最后的null，没写进string里，省略掉了。
		if (queue.isEmpty()) {
			return null;
		}
		
		int val = Integer.parseInt(queue.peek());
		if (val < low || val > high) {
			return null;
		}
		TreeNode root = new TreeNode(Integer.parseInt(queue.poll()));
		root.left = dfs2(queue, low, root.val);
		root.right = dfs2(queue, root.val, high);
		return root;
	}
}
