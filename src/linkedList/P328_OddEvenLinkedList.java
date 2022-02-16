package linkedList;

public class P328_OddEvenLinkedList {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode evenHead = head.next;
		ListNode odd = head, even = evenHead;
		//注意完成此判断标准时，最后的even和odd还没有断开，还连着
		while (even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		//注意最后这一步，如果单纯是分开两个链表，也要把最后的odd.next指向null，否则的话实际上最后一个链表还没分开
		odd.next = evenHead;
		return head;
    }
}
