package z;

public class P549_BinaryTreeLongestConsecutiveSequence2 {
	//time n
	//space h
	int ans = 0;
	
	public int longestConsecutive(TreeNode root) {
		dfs(root);
		return ans;
    }

    private int[] dfs(TreeNode root) {
    	if (root == null) {
    		return new int[2];
    	}
    	
    	int[] res = new int[] {1, 1};
    	
    	if (root.left != null) {
    		int[] left = dfs(root.left);
    		if (root.left.val == root.val + 1) {
    			res[0] = left[0] + 1;
    		} else if (root.left.val == root.val - 1) {
    			res[1] = left[1] + 1;
    		}
    	}
    	
    	if (root.right != null) {
    		int[] right = dfs(root.right);
    		if (root.right.val == root.val + 1) {
    			res[0] = Math.max(res[0], right[0] + 1);
    		} else if (root.right.val == root.val - 1) {
    			res[1] = Math.max(res[1], right[1] + 1);
    		}
    	}
    	//因为定点被算了两次，所以要-1
    	ans = Math.max(ans, res[0] + res[1] - 1);
    	return res;
    }
}
