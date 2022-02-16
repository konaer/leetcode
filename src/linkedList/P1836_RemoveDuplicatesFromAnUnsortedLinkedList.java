package linkedList;

public class P1836_RemoveDuplicatesFromAnUnsortedLinkedList {
	public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();

        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        while (cur != null) {
        	//此处错了，应该注意，哈希表里只能放node.val, 不能放node
            map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
            cur = cur.next;
        }

        cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            if (map.get(cur.val) == 1) {
                pre.next = cur;
                pre = cur;
            }
            cur = cur.next;
        }
        //别忘了这个，最后一个node的next需要断开原来的，并设为null
        pre.next = null;
        return dummy.next;      
    }
}
