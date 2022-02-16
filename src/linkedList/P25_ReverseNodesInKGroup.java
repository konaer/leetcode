package linkedList;

public class P25_ReverseNodesInKGroup {
	//o(n), 每次reverse是k，一共n/k组，总体是n
	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy; 
		
		while (head != null) {
			ListNode tail = pre;
			//走几步是直接尾减头，但是此处k的下标是k-1，所以实际上是 (k-1) - (-1)
			for (int i = 0; i < k; i++) {
				//这里错了一次，注意是先让tail走，然后再判断if
				tail = tail.next;
				if (tail == null) {
					return dummy.next; 
				}
			}

			ListNode newHead = tail.next;
			tail.next = null;
			reverse(head);
			head.next = newHead;
			pre.next = tail;
			//这个地方错过一次
			pre = head;
			head = newHead;
		}
		return dummy.next;
    }
	
	private void reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while(cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
	}
}
