package linkedList;

public class P143_reorderLinkedList {
	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		
		ListNode f = head, s = head;
		//这个经常用，一定要记住，快慢指针停止条件！
		while (f.next != null && f.next.next != null) {
			f = f.next.next;
			s = s.next;
		}
		ListNode secondHead = s.next;
		//记得断开！！这里错了一次
		s.next = null;
		secondHead = reverse(secondHead);
		connect(head, secondHead);
    }
	
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	private void connect(ListNode head, ListNode secondHead) {
		while (head != null && secondHead != null) {
			ListNode newHead = head.next;
			head.next = secondHead;
			secondHead = secondHead.next;
			head.next.next = newHead;
			head = newHead;
		}
	}
	
}
