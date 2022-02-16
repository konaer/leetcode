package binaryTree;

public class P94_BinaryTreeInorderTravesal {
	
	//时间n，遍历时间
	//空间n，栈空间
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        while (! stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            ans.add(node.val);
            node = node.right;
        }
        return ans;
    }
}
