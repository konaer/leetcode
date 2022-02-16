package sorting;

import java.util.PriorityQueue;
import java.util.Queue;

public class P23_MergeKSortedList {
	//优先队列有k个数，所以插入和删除都是logk，一共最多进行kn个点插入和删除
	//时间为 kn*logk
	//空间为 priorityqueue空间，里面一共k的元素，所以是k
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		
		for (ListNode node : lists) {
			if (node != null) {
				pq.offer(node);
			}
		}
		
		while (!pq.isEmpty()) {
			cur.next = pq.poll();
			cur = cur.next;
			if (cur.next != null) {
				pq.add(cur.next);
			}
		}
		return dummy.next;
    }
}
