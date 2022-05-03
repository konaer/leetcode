package z;

import org.w3c.dom.Node;

public class P430_FlattenMultilevelDoublyLinkedList {
	public Node flatten(Node head) {
		dfs(head);
		return head;
	}

	private Node dfs(Node node) {
		Node last = node;
		while (node != null) {
			if (node.child == null) {
				last = node;
				node = node.next;
			} else {
				Node temp = node.next;
				Node childLast = dfs(node.child);
				node.next = node.child;
				node.child.prev = node;
				node.child = null;
				
				childLast.next = temp;
				if (temp != null) {
					temp.prev = childLast;
				}
				node = childLast;
			}
		}
		return last;
	}
}
