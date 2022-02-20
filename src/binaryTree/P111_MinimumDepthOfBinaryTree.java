package binaryTree;

public class P111_MinimumDepthOfBinaryTree {
	//time n
	//space n
	public int minDepth(TreeNode root) {
        if (root == null) {
        	return 0;
        }
        
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        
        if (root.left == null && root.right == null) {
        	return 1;
        } else if (root.left == null || root.right == null) {
        	return l + r + 1;
        } else {
        	return Math.min(l, r) + 1;
        }
    }
	
	
}
