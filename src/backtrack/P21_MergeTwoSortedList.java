package backtrack;

public class P21_MergeTwoSortedList {
	
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
