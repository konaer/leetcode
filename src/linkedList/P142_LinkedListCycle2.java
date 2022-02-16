package linkedList;

public class P142_LinkedListCycle2 {
	//判断相遇，慢指针最多走到N步。 判断点位，快指针也最多走N步，加起来是2n，时间复杂度就是n
	//空间只需要指针的，01
	public ListNode detectCycle(ListNode head) {
		
		//要想保证答案对，此处开始的时候，两个指针都必须是指head，不能一个head，一个head，next
		ListNode fast = head, slow = head;
		do {
			//错一此处是fast，不是head，错二，此处是或，不是与
			if (fast == null || fast.next == null) {
				return null;
			}
			fast = fast.next.next;
			slow = slow.next;
		} while (fast != slow);
		
		fast = head;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return fast;		
	}
}
