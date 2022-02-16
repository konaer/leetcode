package binaryTree;

public class P559_MaximumDepthofNaryTree {
	public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int maxChild = 0;
        for (Node child : root.children) {
            maxChild = Math.max(maxChild, maxDepth(child));
        }
        return maxChild + 1;
    }
}
