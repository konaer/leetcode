package binaryTree;

public class P236_LowestCommonAncestor {
	//自下而上，时间是n
	//栈空间，最差是n
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
        	return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p , q);

        if (left == null) {
        	return right;
        } 
        if (right == null) {
        	return left;
        }
        return root;        
    }
	
//	private TreeNode ans;
//	
//	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//		dfs(root, p, q);
//		return ans;
//	}
//	
//	private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
//		if (root == null) {
//			return false;
//		}
//		
//		boolean l = dfs(root.left, p, q);
//		boolean r = dfs(root.right, p, q);
//		
//		if ((l && r) || ((l || r) && (root == p || root == q))) {
//			ans = root;
//		}
//		return (l || r) || (root == p) || (root == q);
//	}
	
	
}
