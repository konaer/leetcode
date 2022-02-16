package linkedList;

import java.util.HashSet;
import java.util.Set;

public class P141_LinkedListCycle {
	//时间n,最坏需要遍历节点
	//空间n, set里面
//	public boolean hasCycle(ListNode head) {
//        if (head == null) {
//        	return false;
//        }
//		
//		Set<ListNode> set = new HashSet<>();
//        while (head != null) {
//        	if (set.contains(head)) {
//        		return false;
//        	}
//        	set.add(head);
//        	head = head.next;	
//        }
//        return true;
//    }
	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
	           return false;
	        }
	        
	        ListNode f = head, s = head;
	        //此处需要判断两个，是因为fast每次跳两步
	        while (f != null && f.next != null) {
	        	//注意要先加快慢指针，否则上来两个就一样了，都指向head
	            f = f.next.next;
	            s = s.next;
	            if (f == s) {
	                return true;
	            }
	        }
	        return false;
	}
	
}
