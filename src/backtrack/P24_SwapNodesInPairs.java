package backtrack;

public class P24_SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode n1 = head, n2 = head.next;
		//注意这里错了，应该是先搞定N1的next，然后再N2，因为n1的next需要递归。
		n1.next = swapPairs(n2.next);
		n2.next = n1;
		return n2;
    }
}
