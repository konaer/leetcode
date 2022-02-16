package binaryTree;

import java.util.List;

public class P113_PathSum2 {
	//n^2 最坏情况n个解，n层，所以每个解需要n的时间放入list
	//空间n层
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) { 
        dfs(root, targetSum);
        return ans;   
    }

    private void dfs(TreeNode root, int targetSum) {
        if (root == null) {
            return;
        }
        
        list.add(root.val);
        if (root.left == null && root.right == null
        		&& root.val == targetSum) {
        	//注意这个地方一定不能提前return，因为后面还需要不停的遍历
        	//一直要遍历到最后root== null的出口
        	ans.add(new ArrayList<>(list));
        }

        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        list.remove(list.size() - 1);
    }
}
