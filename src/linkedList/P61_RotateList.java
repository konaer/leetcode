package linkedList;

public class P61_RotateList {
	//最坏情况遍历2次，2n。时间复杂度n
	public ListNode rotateRight(ListNode head, int k) {
		//注意判定边界条件，此处错了
		if (head == null || head.next == null || k == 0) {
			return head;
		}
		
		ListNode tail = head;
		int count = 1;
		while (tail.next != null) {
			tail = tail.next;
			count++;
		}
		
		k = count - (k % count) + 1;
		tail.next = head;
		//记住这个，从1开始，走k步
		for (int i = 1; i < k; i++) {
			tail = tail.next;
		}
		head = tail.next;
		tail.next = null;
		
		return head;		
    }
}
