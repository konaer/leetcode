package backtrack;

public class N494_TargetSum {

	//time 2^n
	//space n
	public int findTargetSumWays(int[] nums, int target) {
		int count = 0;

	    public int findTargetSumWays(int[] nums, int target) {
	        dfs(nums, target, 0);
	        return count;
	    }

	    private void dfs(int[] nums, int target, int index) {
	        if (index == nums.length) {
	            if (target == 0) {
	                count++;
	            }
	            return;
	        }
	        
	        dfs(nums, target + nums[index], index + 1);
	        dfs(nums, target - nums[index], index + 1);
	    }
    }
}
