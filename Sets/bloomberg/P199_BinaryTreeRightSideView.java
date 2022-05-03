package z;

import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class P199_BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		
		if (root == null) {
			return ans; 
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (i = size - 1) {
					ans.add(node.val);
				}
			}
		}
		return ans;
    }
}
