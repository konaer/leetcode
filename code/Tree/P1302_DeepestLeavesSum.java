package binaryTree;

public class P1302_DeepestLeavesSum {
	
	//dfs做法
	private int maxDepth = -1;
    private int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }

        if (depth > maxDepth) {
            sum = node.val;
            maxDepth = depth;
        } else if (depth == maxDepth) {
            sum += node.val;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
    
    //bfs做法
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            sum = 0;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                sum += root.val;
                if (root.left != null) {
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
        }
        return sum;
    }
}
