package z;

import java.util.List;
import java.util.Set;

public class P653_TwoSum4_InputIsBST {
	//time traversal n
	//space set space, n
	 public boolean findTarget(TreeNode root, int k) {
		 Set<Integer> set = new HashSet<>();
		 return dfs(root, k, set);
	 }
	 
	 private boolean dfs(TreeNode root, int k, Set<Integer> set) {
		 if (root == null) {
			 return false;
		 }
		 
		 if (set.contains(k - root.val)) {
			 return true;
		 }
		 
		 set.add(root.val);
		 return dfs(root.left, k, set) || dfs(root.right, k, set);
	 }
	 
	 //inorder traversal
	 public boolean findTarget(TreeNode root, int k) {
		 List<Integer> list = new ArrayList<>();
		 traversal(root, list);
		 
		 int l = 0, r = list.size() - 1;
		 while (l < r) {
			 if (list.get(l) + list.get(r) == k) {
				 return true;
			 } else if (list.get(l) + list.get(r) > k) {
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
