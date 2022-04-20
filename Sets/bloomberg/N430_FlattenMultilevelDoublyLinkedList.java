package z;

import org.w3c.dom.Node;

public class N430_FlattenMultilevelDoublyLinkedList {
	public Node flatten(Node head) {
		dfs(head);
		return head;
	}

	private Node dfs(Node head) {
		Node last = head;
		while (head != null) {
			if (head.child == null) {
				last = head;
				head = head.next;
			} else {
				Node tmp = head.next;
				Node childLast = dfs(head.child);
				head.next = head.child;
				head.child.prev = head;
				head.child = null;
				if (childLast != null)
					childLast.next = tmp;
				if (tmp != null)
					tmp.prev = childLast;
				last = head;
				head = childLast;
			}
		}
		return last;
	}
}
