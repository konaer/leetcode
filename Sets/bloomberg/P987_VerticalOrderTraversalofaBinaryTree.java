package binaryTree;

import java.util.Collections;
import java.util.List;

public class P987_VerticalOrderTraversalofaBinaryTree {
	//time nlogn,   sort use nlogn, traversal use n, traversal 2 times
	//space n stack and list
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<int[]> list = new ArrayList<>();
		dfs(root, list, 0, 0);
		Collections.sort(list, (a, b) -> {
			if (a[0] != b[0]) {
				return a[0] - b[0];
			} else if (a[1] != b[1]) {
				return a[1] - b[1];
			} else {
				return a[2] - b[2];
			}
		});
		
		int index = Integer.MIN_VALUE;
		List<List<Integer>> ans = new ArrayList<>();
		for (int[] node : list) {
			//不等于，证明index滚动到下一个了
			if (node[0] != index) {
				index = node[0];
				ans.add(new ArrayList<>());
			}
			ans.get(ans.size() - 1).add(node[2]);
		}
		return ans;
    }
	
	private void dfs(TreeNode root, List<int[]> list, int row, int col) {
		if (root == null ) {
			return;
		}
		
		list.add(new int[] {col, row, root.val});
		dfs(root.left, list, row + 1, col - 1);
		dfs(root.right, list, row + 1, col + 1);
	}
}
