package hashTable;

import java.util.HashSet;
import java.util.Set;

//另外一种方法，在linkedlist包里面
public class P160_IntersectionOfTwoLinkedLists {
	
	//时间上需要遍历m进set，然后再遍历n，所以是 m+n
	//空间需要m
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<>();
		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}
		
		while (headB != null) {
			if (set.contains(headB)) {
				return headB;
			}
			headB = headB.next;
		}
		return null;
    }
}
