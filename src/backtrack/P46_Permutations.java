package backtrack;

import java.util.*;

public class P46_Permutations {
	// 非子叶节点，一共 n! + n!/(n - 1)! + …………+ n!/2! < 2n!所以是2n！
	//子叶节点拷贝一次需要n，一共 n！ 个节点，所以是 n*n!,
	//综合起来就是n*n！
	
	//空间递归需要N层， 如果不算结果的空间，是n
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        dfs(nums, visited);
        return ans;
    }

    private void dfs(int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
	
	//时间，backtrack调用时间n！，参考上面的。子叶节点复制数组需要n时间，一共n！个
	//总时间就是 n*n！
	
	//额外空间是 stack space， 主要看递归的深度，n层。所以是n
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		int len = nums.length;
		int index = 0;
		
		if (nums == null || len == 0) {
			return ans;
		}
		
		for (int num : nums) {
			list.add(num);
		}
		
		backtrack(ans, list, len, index);
		return ans;
	}
	
	private void backtrack(List<List<Integer>> ans, List<Integer> list, int len, int index) {
		if (index == len) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = index; i < len; i++) {
			Collections.swap(list, index, i);
			backtrack(ans, list, len, index + 1);
			Collections.swap(list, index, i);
		}
	}
	
	

}
