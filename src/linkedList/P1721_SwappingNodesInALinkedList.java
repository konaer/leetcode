package linkedList;

public class P1721_SwappingNodesInALinkedList {
	public ListNode swapNodes(ListNode head, int k) {
		ListNode f = head, s = head;
		for (int i = 0; i < k - 1; i++) {
			f = f.next;
		}
		ListNode node1 = f;
		
		//错了一次，注意此处是f.next， 区别是只走到了最后一个node
		//如果是f != null，还会往下走一步，直到f==null
		while (f.next != null) {
			f = f.next;
			s = s.next;
		}
		ListNode node2 = s;
		
		int temp = node1.val;
		node1.val = node2.val;
		node2.val = temp;
		
		return head;
    }
}
