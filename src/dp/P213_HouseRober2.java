package dp;

public class P213_HouseRober2 {
	//time n
	//space n
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int[] l1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
		int[] l2 = Arrays.copyOfRange(nums, 1, nums.length);
		return Math.max(helper(l1), helper(l2));
    }
	
	private int helper(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}
}
