package bfs;

import java.util.*;

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//
//	TreeNode() {
//	}
//
//	TreeNode(int val) {
//		this.val = val;
//	}
//
//	TreeNode(int val, TreeNode left, TreeNode right) {
//		this.val = val;
//		this.left = left;
//		this.right = right;
//	}
//}

//runtime complexity o(n), space complexity o(n)
public class P111_Minimum_Depth_of_Binary_Tree {
	public int minDepth(TreeNode root) {
		int depth = 0;
		if (root == null) {
			return depth;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return 0;
    }
}
