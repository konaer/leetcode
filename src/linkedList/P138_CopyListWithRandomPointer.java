package linkedList;

import java.util.*;

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}

public class P138_CopyListWithRandomPointer {

//	//时间，访问next。random各一次，一共2n
//	//空间 n，哈希表
//	Map<Node, Node> map = new HashMap<>();
//	
//	public Node copyRandomList(Node head) {
//		//结束回溯的条件
//		if (head == null) {
//			return null;
//		}
//		
//        if (!map.containsKey(head)) {
//        	Node newHead = new Node(head.val);
//        	map.put(head, newHead);
//        	newHead.next = copyRandomList(head.next);
//        	newHead.random = copyRandomList(head.random);
//        }        
//        return map.get(head);
//    }

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		Node cur = head;
		while (cur != null) {
			Node copy = new Node(cur.val);
			copy.next = cur.next;
			cur.next = copy;
			//这个地方忘了好几次了，要注意
			cur = copy.next;
		}

		cur = head;
		while (cur != null) {
			cur.next.random = (cur.random == null ? null : cur.random.next);
			cur = cur.next.next;
		}

		Node copyHead = head.next, copy = head.next;
		cur = head;
		//这里要注意，搞清楚。实际上走到最后一个node就停了。
		//不停的话，因为cur已经是null，到了cur.next这一步就nullpointer了
		//所以最后需要手动cur.next = null；
		while (copy.next != null) {
			cur.next = copy.next;
			cur = cur.next;
			copy.next = cur.next;
			copy = copy.next;
		}
		cur.next = null;
		//注意这个copyHead省不了，因为链表结构变了，head.next已经不是原来的了。
		return copyHead;
	}
}
