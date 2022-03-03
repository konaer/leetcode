package binaryTree;

import java.util.Deque;

public class P426_ConvertBinarySearchTreeToSortedDoublyLinkedList {
	//时间n
	//空间最差n，最好logn
	Node head = null, pre = null;
	
	public Node treeToDoublyList(Node root) {
		//这里要做出一次判断，否则下面的head.left就nullpointer了
        if (root == null) {
            return root;
        }

		helper(root);
		head.left = pre;
		pre.right = head;
		return head;
    }
	
	private void helper(Node node) {
		if (node == null) {
			return;
		}
		
		helper(node.left);
		if (pre == null) {
			head =  node;
		} else {
			pre.right = node;
			node.left = pre;
		}
		pre = node;
		helper(node.right);
	}
}
