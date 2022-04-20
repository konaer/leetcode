package z;

// https://leetcode.com/discuss/interview-question/1546673/Amazon-or-OA-or-LinkedListSum

public class singleLinkedList {
	
	static class ListNode{
		int val;
		ListNode next;
		ListNode() {};
		ListNode(int val) {
			this.val = val;
		}
	}
	
	public static int find(ListNode head){
		int size = 0;
		ListNode node = head;
		while(node != null){
			size++;
			node = node.next;
		}
		
		int n = size/2;
		if(head == null){
			return 0;
		}
		
		ListNode preNode = head;
		ListNode curNode = head.next;
		ListNode nextNode = null;
		for(int i=0; i<n-1; i++){
			if(curNode != null){
				nextNode = curNode.next;
				curNode.next = preNode;
				preNode = curNode;
				curNode = nextNode;
			}
		}
// after reverse curNode --- is the start node for next group
		ListNode firstHalf = preNode;
		ListNode secondNode = curNode;
		int max = 0;
		while (firstHalf != null && secondNode != null) {
			max = Math.max(firstHalf.val + secondNode.val , max);
			firstHalf = firstHalf.next;
			secondNode = secondNode.next;
		}
		return max;
	}	
}

