package backtrack;

public class P47_Permutations2 {
	
	//时间 n*n! 参考46
	//空间 n，栈空间，n层
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
    	//要先sort
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited);
        return ans;
    }
    
    private void backtrack(int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            //注意需要是i- 1 还没用过才剪枝，如果用过，那可以继续用
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backtrack(nums, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
