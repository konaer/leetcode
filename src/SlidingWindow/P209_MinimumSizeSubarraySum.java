package SlidingWindow;

public class P209_MinimumSizeSubarraySum {
	//时间n
	//空间l
	public int minSubArrayLen(int target, int[] nums) {
		int l = 0, r = 0, sum = 0;
		int ans = Integer.MAX_VALUE;
				
		while (r < nums.length) {
			sum += nums[r];
			while (sum >= target) {
				ans = Math.min(ans, r - l + 1);
				sum -= nums[l++];
			}
			r++;
		}
		//注意这里要判断，有一种情况是sum一直不大于target，所以ans初始值没变过
		return ans == Integer.MAX_VALUE? 0 : ans;
    }
}
