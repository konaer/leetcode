package binaryTree;

import java.util.List;

public class P173_BinarySearchTreeIterator {
	//初始化需要n时间， 之后每次调用 1 时间
	//空间 n，需要保存遍历结果
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
		//每次调用next（）完后，index指在下一个数了。
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
