package z;

import java.util.Arrays;

// http://webcache.googleusercontent.com/search?q=cache:E1TymPvVpXIJ:https://leetcode.com/discuss/interview-question/1735633/Amazon-OA-2022&hl=en&gl=us&strip=1&vwsrc=0
public class primeVideo {
	public static int find(int[] nums, int k) {
		int ans = 1;
		Arrays.sort(nums);
		int minNum = nums[0];
		for (int num : nums) {
			if (num - minNum > k) {
				minNum = num;
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,5,4,6,8,9,2};
		int k = 3;
		System.out.println(find(nums, k));
	}
}
