package backtrack;

public class P203_RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        
        //先判断head.next，再去处理head
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
