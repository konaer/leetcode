package z;

import java.util.List;

public class P1214_TwoSumBSTs {
	//time m + n
	//space m + n
	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		
		traversal(root1, list1);
		traversal(root2, list2);
		
		int l = 0, r = list2.size() - 1;
		while (l < list1.size() && r >= 0) {
			int sum = list1.get(l) + list2.get(r);
			if (sum == target) {
				return true;
			} else if (sum > target) {
				r--;
			} else {
				l++;
			}
		}
		return false;
		
    }
	
	private void traversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		
		traversal(root.left, list);
		list.add(root.val);
		traversal(root.right, list);
	}
}
