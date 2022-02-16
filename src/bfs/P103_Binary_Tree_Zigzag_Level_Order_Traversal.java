package bfs;

import java.util.*;


public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
        		
		if (root == null) {
        	return result;
        }
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isFromLeft = true;
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();			
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (isFromLeft) {
					level.add(node.val);
				} else {
					level.add(0, node.val);
				}
				
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			result.add(level);
			isFromLeft = !isFromLeft;
		}
		return result;      
    }
}
