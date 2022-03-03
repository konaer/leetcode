package binaryTree;

public class P112_PathSum {
	//时间n
	//空间最差n，最好logn
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}
        
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
		
		boolean l = hasPathSum(root.left, targetSum - root.val);
		boolean r = hasPathSum(root.right, targetSum - root.val);
		
		return l || r;
    }
}
