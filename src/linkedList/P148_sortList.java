package linkedList;

public class P148_sortList {
	// 时间复杂度，归并排序 nlogn
	// 空间递归占用的栈空间 log n
	public ListNode sortList(ListNode head) {
		
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode secondHead = findMid(head);
		ListNode list2 = sortList(secondHead);
		ListNode list1 = sortList(head);
		return merge(list1, list2);
    }
	
	private ListNode findMid(ListNode head) {
		ListNode f = head, s = head;
		//注意这里一定把 f.next 写在前面！！！
		while (f.next != null && f.next.next != null) {
			f = f.next.next;
			s = s.next;
		}
		ListNode secondHead = s.next;
		//要记得断开
		s.next = null;
		return secondHead;
	}
	
	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}
		pre.next = (l1 == null ? l2 : l1);
		return dummy.next;
	}
}
