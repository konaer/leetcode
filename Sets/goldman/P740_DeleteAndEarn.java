package z;

public class P740_DeleteAndEarn {
	//time m + n
	//space m
	public int deleteAndEarn(int[] nums) {
		int max = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
		}
		
		int[] points = new int[max + 1];
		for (int num : nums) {
			points[num] += num;
		}
		
		
		int[] dp = new int[max + 1];
		dp[0] = 0;
		dp[1] = points[1];
		
		for (int i = 2; i <= max; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
		}
		return dp[max];
    }
}
