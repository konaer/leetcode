package monotoneStack;

import java.util.Deque;
import java.util.List;

import linkedList.ListNode;

public class P1019_nextGreaterNodeInLinkedList {
	//翻转链表解法
	public int[] nextLargerNodes(ListNode head) {
		ListNode newHead = reverse(head);
		Deque<Integer> stack = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		while (newHead != null) {
			while (!stack.isEmpty() && newHead.val >= stack.peek()) {
				stack.pop();
			}
			list.add(stack.isEmpty() ? 0 : stack.peek());
			stack.push(newHead.val);
			newHead = newHead.next;
		}
        
        int n = list.size();
		int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = list.get(n - i - 1);
        }
		return ans;
    }
	
	private ListNode reverse(ListNode head) {
		ListNode pre = null, cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	
	//monotonous stack
	public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		
		int n = list.size();
		int[] ans = new int[n];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = n - 1; i >= 0; i--) {
			while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
				stack.pop();
			}
			ans[i] = (stack.isEmpty() ? 0 : stack.peek());
			stack.push(list.get(i));
		}
		return ans;
	}
}
