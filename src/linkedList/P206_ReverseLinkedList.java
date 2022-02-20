package linkedList;
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}

public class P206_ReverseLinkedList {
	//遍历链表，时间复杂度n
	//空间复杂度 1
	public ListNode reverseList(ListNode head) {
		ListNode pre = null, cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	
	//dfs
	//time n
	//space n
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}
