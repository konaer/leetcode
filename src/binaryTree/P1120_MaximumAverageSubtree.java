package binaryTree;

public class P1120_MaximumAverageSubtree {
	//时间o(n)自底向上，遍历一次
	//空间n，最好情况logn
	double res = 0;
	
	public double maximumAverageSubtree(TreeNode root) {
		dfs(root);
		return res; 
    }
	
	private int[] dfs(TreeNode root) {
		//info of subtree sum and size
		int[] info = new int[2];
		if (root == null) {
			return info;
		}
		
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		//sum of subtree
		info[0] = left[0] + right[0] + root.val;
		//size of subtree
		info[1] = left[1] + right[1] + 1;
		
		res = Math.max(res, (double) info[0] / info[1]);
		return info;	
	}
}
