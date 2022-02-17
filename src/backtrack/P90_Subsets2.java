package backtrack;

import java.util.List;

public class P90_Subsets2 {
	// 时间n*2^n, 最差情况，一共2^n个解，每个解需要n时间放进去
	// 空间 stack空间n，list空间n，总共是n级别
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> list = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(nums, 0);
		return ans;
	}

	private void dfs(int[] nums, int index) {
		ans.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			if (i != index && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			ans.add(new ArrayList<>(list));
			dfs(nums, i + 1);
			list.remove(list.size() - 1);
		}
	}

	// 时间 n* 2^n, 一共2^n个答案，每个放入list需要n时间
	// 空间 stack 空间，需要 n 空间
//	List<List<Integer>> ans = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//    
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//    	Arrays.sort(nums);
//    	dfs(nums, 0, false);
//    	return ans;
//    }
//    
//    private void dfs(int[] nums, int index, boolean visited) {
//    	if (index == nums.length) {
//    		ans.add(new ArrayList<>(list));
//    		return;
//    	}
//    	
//    	dfs(nums, index + 1, false);
//    	if (index != 0 && nums[index] == nums[index - 1] && !visited) {
//    		return;
//    	}
//    	list.add(nums[index]);
//    	dfs(nums, index + 1, true);
//    	list.remove(list.size() - 1);
//    }
}
