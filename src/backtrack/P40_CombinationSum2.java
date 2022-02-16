package backtrack;

import java.util.List;

public class P40_CombinationSum2 {
	
	//时间最差是 n* 2^n， 一共2^n种解，每个需要n个时间放入list
	//空间是递归栈，n层
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> list = new ArrayList<>();
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		dfs(candidates, target, 0);
		return ans;
    }
	
	private void dfs(int[] candidates, int target, int index) {
		
		if (target == 0) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = index; i < candidates.length; i++) {
			if (target < candidates[i]) {
				break;
			}
			if (i != index && candidates[i] == candidates[i - 1]) {
				continue;
			}
			list.add(candidates[i]);
			dfs(candidates, target - candidates[i], i + 1);
			list.remove(list.size() - 1);
		}
	}
}
