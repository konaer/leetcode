package linkedList;

public class P160_IntersectionOfTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
        	return null;
        }
        ListNode a = headA, b = headB;
        //要么同时到焦点，要么同时到队尾，变成null了。
        while (a != b) {
        	a = (a == null ? headB : a.next);
        	b = (b == null ? headA : b.next);
        }
        return a;
    }
}
