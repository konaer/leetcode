package binaryTree;

import org.w3c.dom.Node;

public class P1650_LowestCommonAncestor3 {
	
//	public Node lowestCommonAncestor(Node p, Node q) {
//        Set<Node> set = new LinkedHashSet<>();
//        while (p != null) {
//            set.add(p);
//            p = p.parent;
//        }
//        while (q != null) {
//            if (set.contains(q)) {
//                return q;
//            }
//            q = q.parent;
//        }
//        return null;
//    }
	
	//时间两边遍历，n
	//空间l
	public Node lowestCommonAncestor(Node p, Node q) {
		Node m = p, n = q;
		while (m != n) {
			m = m.parent;
			n = n.parent;
			if (m == null) {
				m = q;
			}
			if (n == null) {
				n = p;
			}
		}
		return m;
	}
	
}
