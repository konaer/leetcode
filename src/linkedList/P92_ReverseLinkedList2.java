package linkedList;

public class P92_ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        //这里搞清楚，left - 1 -1是下标，减去-1下标，正好是步数。
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            //这里错了，注意要写成pre.next，不是cur，因为cur一直在变的
            next.next = pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
