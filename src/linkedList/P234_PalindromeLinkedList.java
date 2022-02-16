package linkedList;

public class P234_PalindromeLinkedList {
	//时间 需要遍历，所以是o(n)
	//空间只需要修改链表指向。是 0（1）
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		
		ListNode mid = findMid(head);
		ListNode secondHead = reverse(mid.next);
		
		while (secondHead != null) {
			//注意这里别忘了val，错了一次
			if (head.val != secondHead.val) {
				return false;
			}
			head = head.next;
			secondHead = secondHead.next;
		}
		return true;
		
	}
	//快慢指针
	private ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		//这个地方错了，记住这个快慢指针的条件！！
		//注意要先判断fast.next, 因为可能没有fast.next.next会报错的！
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	//翻转
	private ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		//这个地方错了一次，注意是cur != null,不是head
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	
	//第二种解法，用列表放链表数字，这种空间是n，但是很好想到
//	public boolean isPalindrome(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while (head != null) {
				//注意是val
//            list.add(head.val);
//            head = head.next;
//        }
//        return testPalindrome(list);
//    }
//    
//    private boolean testPalindrome(List<Integer> list) {
//        int l = 0, r = list.size() - 1;
//        while (l < r) {
//            if (list.get(l++) != list.get(r--)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
