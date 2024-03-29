package z;

public class N117_PopulatingNextRightPointersEachNode2 {

	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	}
	
	public Node connect(Node root) {
        if (root == null) {
        	return root;
        }
        
        Node cur = root;
        while (cur != null) {
        	//相当于每一层建立一个链表
        	Node dummy = new Node(0);
        	Node pre = dummy;
        	while (cur != null) {
        		if (cur.left != null) {
        			pre.next = cur.left;
        			pre = pre.next;
        		}
        		if (cur.right != null) {
        			pre.next = cur.right;
        			pre = pre.next;
        		}
        		cur = cur.next;
        	}
        	cur = dummy.next;
        }
        return root;
    }
}
