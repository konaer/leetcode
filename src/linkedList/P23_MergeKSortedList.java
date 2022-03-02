package linkedList;

import java.util.PriorityQueue;
import java.util.Queue;

public class P23_MergeKSortedList {
	// 优先队列有k个数，所以插入和删除都是logk，一共最多进行kn个点插入和删除
	// 时间为 kn*logk
	// 空间为 priorityqueue空间，里面一共k的元素，所以是k
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;

		for (ListNode node : lists) {
			// 这里错了，需要判断
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

	// divid and conquer
	public ListNode mergeKLists(ListNode[] lists) {
		return conquer(lists, 0, lists.length - 1);
	}

	private ListNode conquer(ListNode[] lists, int l, int r) {
		// 这个排除了空集的情况，要注意
		if (l > r) {
			return null;
		}
		if (l == r) {
			return lists[l];
		}

		int mid = l + (r - l) / 2;
		ListNode left = conquer(lists, l, mid);
		ListNode right = conquer(lists, mid + 1, r);
		return merge(left, right);
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l2.next, l1);
			return l2;
		}
	}
}
