package binaryTree;

import java.util.List;

public class P257_BinaryTreePaths {
	//时间n^2， 因为是数组，一共n个节点，储存每个节点需要n时间
	//空间 n^2 , 最差情况n层，每层空间 n。最好情况logn层，空间 （logn）^2
//	public List<String> binaryTreePaths(TreeNode root) {
//		List<String> ans = new ArrayList<>();
//		dfs(root, "", ans);
//		return ans;
//	}
//
//	private void dfs(TreeNode root, String path, List<String> ans) {
//		if (root == null) {
//			return;
//		}
//			path = path + (String.valueOf(root.val));
//			if (root.left == null && root.right == null) {
//				ans.add(path);
//			} else {
//				path = path + "->";
//				dfs(root.left, path, ans);
//				dfs(root.right, path, ans);
//			}
//	}
	
	public List<String> binaryTreePaths(TreeNode root) {
		//时间最差是n^2,所有的节点都在一侧。最好情况是 nLogN
		
        List<String> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		
		List<String> leftPaths = binaryTreePaths(root.left);
		List<String> rightPaths = binaryTreePaths(root.right);
		
		for (String path : leftPaths) {
			ans.add(root.val + "->" + path);
		}
		for (String path : rightPaths) {
			ans.add(root.val + "->" + path);
		}
		if (ans.size() == 0) {
			ans.add("" + root.val);
		}
		
		return ans;
    }
}
