package binaryTree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class P144_BinaryTreePreorderTraversal {
	
//	List<Integer> ans = new ArrayList<>();
//    public List<Integer> preorderTraversal(TreeNode root) {
//        if (root == null) {
//            return ans;
//        }
//        
//        ans.add(root.val);
//        preorderTraversal(root.left);
//        preorderTraversal(root.right);
//        return ans;
//    }
	
//	public List<Integer> preorderTraversal(TreeNode root) {
//		List<Integer> ans = new ArrayList<>();
//		if (root == null) {
//			return ans;
//		}
//		
//		Deque<TreeNode> stack = new LinkedList<>();
//		stack.push(root);
//		while (!stack.isEmpty()) {
//			TreeNode node = stack.pop();
//			ans.add(node.val);
//			if (node.right != null) {
//				stack.push(node.right);
//			}
//			if (node.left != null) {
//				stack.push(node.left);
//			}	
//		}
//		return ans;
//	}
	
	//时间n，遍历
	//空间n， 栈
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode node = root;
		while (!stack.isEmpty() || node != null) {
			while (node != null) {
				ans.add(node.val);
				stack.push(node);
				node = node.left;
			}
			node = stack.pop().right;
		}
		return ans;
	}
}
