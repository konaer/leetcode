package bfs;

import java.util.*;

public class P107_Binary_Tree_Level_Order_Traversal_2 {
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = queue.size();
			
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(0, level);
		}
		return result;		
    }	
}
