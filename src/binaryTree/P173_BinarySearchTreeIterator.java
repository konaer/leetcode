package binaryTree;

import java.util.List;

public class P173_BinarySearchTreeIterator {

	private int index;
	private List<Integer> list;

	public P173_BinarySearchTreeIterator(TreeNode root) {
		index = 0;
		list = new ArrayList<>();
		helper(root, list);
	}

	public int next() {
		return list.get(index++);
	}

	public boolean hasNext() {
		return index < list.size();
	}

	private void helper(TreeNode root, List<Integer> list) {
		if (root == null)
			return;

		helper(root.left, list);
		list.add(root.val);
		helper(root.right, list);
	}
}
