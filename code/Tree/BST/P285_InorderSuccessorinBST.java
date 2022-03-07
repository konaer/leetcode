package binaryTree;

import java.util.Deque;

public class P285_InorderSuccessorinBST {
	//time h
	//space h
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
        	return null;
        }
        
        //这一部分只是加快了速度，没有这部分照样能找到
        TreeNode node = null;
        if (p.right != null) {
        	node = p.right;
        	while (node.left != null) {
        		node = node.left;
        	}
        	return node;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
        	//注意这个地方是root，不是root.left
        	while (root != null) {
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop();
        	if (node == p) {
        		return root;
        	}
        	node = root;
        	root = root.right;
        }
        return null;
    }
}
