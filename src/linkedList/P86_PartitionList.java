package linkedList;

public class P86_PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null) {
			return head;
		}
		
		ListNode smallHead = new ListNode(-1);
		ListNode bigHead = new ListNode(-1);
		ListNode small = smallHead;
		ListNode big = bigHead; 
		
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				big.next = head;
				big = big.next;
			}
			head = head.next;
		}
		small.next = bigHead.next;
		//注意这个地方，要把最后元素的下一个变成null，因为它之前的下一个还没断开，会形成环了。
		big.next = null;
		return smallHead.next; 
    }	
}
