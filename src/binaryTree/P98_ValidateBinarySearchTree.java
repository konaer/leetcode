package binaryTree;

public class P98_ValidateBinarySearchTree {
	//时间遍历时间 n
	//空间 stack空间 最差n，最好logn
	
	
	//这里要用long，避免root正好等于int最大值的情况
//	long low = Long.MIN_VALUE;
//	long high = Long.MAX_VALUE;
//	
//	public boolean isValidBST(TreeNode root) {
//		return isValid(root, low, high);
//    }
//	
//	private boolean isValid(TreeNode root, long low, long high) {
//		if (root == null) {
//			return true;
//		}
//		
//		//注意这个判断有等于号
//		if (root.val <= low || root.val >= high) {
//			return false;
//		}
//		
//		boolean l = isValid(root.left, low, root.val);
//		boolean r = isValid(root.right, root.val, high);
//		return l && r;
//	}
//	
	
	//中序遍历解法
	public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        long val = Long.MIN_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            
            if (root.val <= val) {
                return false;
            }
            val = root.val;
            root = root.right;
        }
        return true;
    }
}
