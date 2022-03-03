package z;

import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class P314_BinaryTreeVerticalOrderTraversal {
	//time n
	//space n
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, Integer> position = new HashMap<>();
		
		int min = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		position.put(root.val, 0);
		
		while (!queue.isEmpty()) {
			root = queue.poll();
			int cur = position.get(root.val);
			map.computeIfAbsent(position.get(root.val), k -> new ArrayList<>()).add(root.val);
			if (root.left != null) {
				queue.offer(root.left);
				position.put(root.left.val, cur - 1);
			}
			if (root.right != null) {
				queue.offer(root.right);
				position.put(root.right.val, cur + 1);
			}
			min = Math.min(min, cur);
		}
		while (map.containsKey(min)) {
			ans.add(map.get(min++));
		}
		return ans;
    }
}
