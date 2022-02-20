package linkedList;

import backtrack.ListNode;

public class P203_removeLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		
		ListNode dummy = new ListNode(0, head);
		ListNode pre = dummy;
		while (pre.next != null) {
			if (pre.next.val == val) {
				pre.next = pre.next.next;
				//这里注意是else，如果满足了if，要接着判断一次，不能直接往下走
			} else {
				pre = pre.next;
			}
		}
		return dummy.next;
    }
	
	//dfs
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        //先判断head.next，再去处理head
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
