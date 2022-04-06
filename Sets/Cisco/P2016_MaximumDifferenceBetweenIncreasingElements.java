package z;

public class P2016_MaximumDifferenceBetweenIncreasingElements {
	//time o(n)
	//space o(l)
	public int maximumDifference(int[] nums) {
		int min = nums[0], ans = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > min) {
				ans = Math.max(ans, nums[i] - min);
			} else {
				min = nums[i];
			}
		}
		return ans;
    }
}
