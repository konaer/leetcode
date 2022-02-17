package backtrack;

import java.util.List;

public class P78_Subsets {
	//迭代
	//时间 n* 2^n, 外层循环需要2^n，内层需要n
	//空间n, 临时list需要的空间
	
//	public List<List<Integer>> subsets(int[] nums) {
//		List<List<Integer>> ans = new ArrayList<>();
//		List<Integer> list = new ArrayList<>();
//		
//		int len = nums.length;
//		for (int i = 0; i < (1 << len); i++) {
//			list.clear();
//			for (int j = 0; j < len; j++) {
//				if ((i & 1 << j) != 0) {
//					list.add(nums[j]);
//				}
//			}
//			ans.add(new ArrayList<>(list));
//		}
//		return ans;
//    }
	
	//递归，
	//时间n*2^n， 一共2^n个可能，每一个需要n的时间构造list
	//空间 list是n， 栈空间是n，综合起来是n
//	List<List<Integer>> ans = new ArrayList<>();
//	List<Integer> list = new ArrayList<>();
//	
//	public List<List<Integer>> subsets(int[] nums) {
//		dfs(0, nums);
//		return ans;
//	}
//	
//	private void dfs(int cur, int[] nums) {
//		if (cur == nums.length) {
//			ans.add(new ArrayList<>(list));
//			//别忘了这里需要return
//			return;
//		}
//		
//		list.add(nums[cur]);
//		dfs(cur + 1, nums);
//		list.remove(list.size() - 1);
//		dfs(cur + 1, nums);	
//	}
	
	
	//第三种解法，按照1， 1,2 1,2,3， 2， 2,3， 3这个顺序递归的
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int index) {
        ans.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
