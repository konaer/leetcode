package sorting;

public class P230_KthSmallestElementInBST {
	//时间 H + k, 先从最顶上下来，所以要树高个，然后再遍历k个，找到第k小
	//空间栈空间，最少 logn，最多存n个
	public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || ! stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
            	break;
            }
            root = root.right;
        }
        return root.val;
    }
}
