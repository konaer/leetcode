package linkedList;

import backtrack.ListNode;

public class P21_MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode pre = dummy;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				pre.next = list1;
				list1 = list1.next;
			} else {
				pre.next = list2;
				list2 = list2.next;
			}
			pre = pre.next;
		}
		//两个都是null，也适用
		pre.next = (list1 == null ? list2 : list1);
		
		return dummy.next;
    }
	
	//dfs
	//时间m+n，递归最多调用每个节点一次
		//空间m+n,递归需要用到stack space，一共m+n的深度
		public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
			if (list1 == null) {
	            return list2;
	        } else if (list2 == null) {
	            return list1;
	        }

	        if (list1.val <= list2.val) {
	            list1.next = mergeTwoLists(list1.next, list2);
	            return list1;
	        } else {
	            list2.next = mergeTwoLists(list2.next, list1);
	            return list2;
	        }
	    }
}
