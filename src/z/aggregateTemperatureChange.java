package z;

//https://www.1point3acres.com/bbs/thread-883477-1-1.html

public class aggregateTemperatureChange {
	public static int find(int[] nums) {
		int ans = 0, ag = 0;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		
		int leftSum = 0, rightSum = sum;
		for (int i = 0; i < nums.length; i++) {
			leftSum += nums[i];
			rightSum = sum - leftSum + nums[i];
			ag = Math.max(leftSum, rightSum);
			ans = Math.max(ag, ans);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 2, 3};
		System.out.println(find(nums));
	}
}
