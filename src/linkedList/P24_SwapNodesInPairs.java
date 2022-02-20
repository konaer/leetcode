package linkedList;

import backtrack.ListNode;

public class P24_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null) {
			return null;
		}
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		while (pre.next != null && pre.next.next != null) {
			ListNode n1 = pre.next;
			ListNode n2 = pre.next.next;
			n1.next = n2.next;
			n2.next = n1;
			pre.next = n2;
			pre = n1;
		}
		return dummy.next;
    }
	
	//dfs
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode n1 = head, n2 = head.next;
		//注意这里错了，应该是先搞定N1的next，然后再N2，因为n1的next需要递归。
		n1.next = swapPairs(n2.next);
		n2.next = n1;
		return n2;
    }
}
