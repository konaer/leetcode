package binaryTree;

public class P99_RecoverBinarySearchTree {
	//时间n
	//空间n
	TreeNode pre = null, m1 = null, m2 = null;
	
	public void recoverTree(TreeNode root) {
		helper(root);
		swap(m1, m2);
    }
	
	private void helper(TreeNode root) {
		if (root == null) return;
		helper(root.left);
		if (pre != null) {
			if (pre.val > root.val) {
				//这里是发现错之后，先确定了m1，但是m2并不一定是root，
				//也可能是恰好m1错了，把它带错了，所以接着找，直到再找到
				//pre.va > root.val对的情况，才确定m2
				if (m1 == null) {
					m1 = pre;
				}
				m2 = root;
			}
		}
		pre = root;
		helper(root.right);
	} 
	
	private void swap(TreeNode p, TreeNode q) {
		int temp = p.val;
		p.val = q.val;
		q.val = temp;
	}
}
