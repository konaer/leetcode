package z;

public class P1472_DesignBrowserHistory {
	
	class Node {
		Node pre;
		Node next;
		String url;
		
		Node() {};
		Node(String url) {
			this.url = url;
		}
	}
	
	Node cur;
	public BrowserHistory(String homepage) {
		cur = new Node(homepage);
    }
    
    public void visit(String url) {
    	Node nNode = new Node(url);
    	cur.next = nNode;
    	nNode.pre = cur;
    	cur = cur.next;
    }
    
    public String back(int steps) {
    	while (cur.pre != null && steps > 0) {
    		cur = cur.pre;
    		steps--;
    	}
    	return cur.url;
    }
    
    public String forward(int steps) {
    	while (cur.next != null && steps > 0) {
    		cur = cur.next;
    		steps--;
    	}
    	return cur.url;
    }
}
