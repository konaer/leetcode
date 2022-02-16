package dp;

public class P494_TargetSum {
	//时间2^n， 一共有2^n种情况，每种需要o（1）时间处理
	//空间 n， stack需要的空间
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
        
        dfs(nums, target - nums[index], index + 1);
        dfs(nums, target + nums[index], index + 1);
    }
}
