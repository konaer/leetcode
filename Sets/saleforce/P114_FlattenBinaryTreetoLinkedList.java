package binaryTree;

public class P114_FlattenBinaryTreetoLinkedList {
	
	TreeNode pre = null;
	public void flatten(TreeNode root) {
		if (root == null) return;
		
		if (pre != null) {
			pre.left = null;
			pre.right = root;
		}
		pre = root;
		//注意进行完左子树的部分时，root.right已经变了
		//所以要提前拿出来
		TreeNode right = root.right;
		flatten(root.left);
		flatten(right);
    }
	
}
