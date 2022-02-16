package linkedList;

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
}
