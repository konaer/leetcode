package z;

import java.util.HashSet;
import java.util.Set;

//https://www.1point3acres.com/bbs/thread-857477-1-1.html

class Node {
	Node next;
	int val;
	Node() {};
	Node(int val) {
		this.val = val;
	}
}

public class CondensedList {
	public static Node find(Node root) {
		Set<Integer> set = new HashSet<>();
		Node dummy = new Node(0);
		dummy.next = root;
		Node node = dummy;
		
		while (node.next != null) {
			if (!set.contains(node.next.val)) {
				set.add(node.next.val);
				node = node.next;
			} else {
				node.next = node.next.next;
			}
		}
		return dummy.next;
	}
	
	public static void main(String[] args) {
		Node node1 = new Node(3);
		Node node2 = new Node(4);
		Node node3 = new Node(3);
		Node node4 = new Node(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		Node root = find(node1);
		System.out.println(root.val);
		System.out.println(root.next.val);
		System.out.println(root.next.next.val);
	}
}
