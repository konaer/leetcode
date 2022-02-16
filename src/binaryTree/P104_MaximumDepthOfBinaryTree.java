package binaryTree;

import java.util.*;

public class P104_MaximumDepthOfBinaryTree {
	
	//时间最坏是n，最好是logn
	//空间1
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return Math.max(leftDepth, rightDepth) + 1;
    }
}
