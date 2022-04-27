package z;

//https://leetcode.com/discuss/interview-question/1789737/amazon-OA

public class primeGames {
	public static int find(int[] nums, int k) {
		int maxNum = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			maxNum = Math.max(maxNum, nums[i]);
			sum += nums[i];
		}
		if (k >= maxNum) {
			return sum - maxNum + 1;
		} else {
			return sum - k + 1;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,6,7};
		int k = 5;
		System.out.println(find(nums, k));
	}
}
