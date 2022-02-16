package linkedList;

public class P82_RemoveDuplicatesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0, head);
		ListNode iter = dummy;
		//画图可知，如果最后剩两个，因为前面的判断，iter此时肯定和iter.next不一样，
		//那么最后剩的iter.next和null直接挂上去就行了，不用再判断了
		while (iter.next != null && iter.next.next != null) {
			if (iter.next.val == iter.next.next.val) {
				int x = iter.next.val;
				while (iter.next != null && iter.next.val == x) {
					iter.next = iter.next.next;
				}
			} else {
				iter = iter.next;
			}
		}
		return dummy.next;
    }
}
