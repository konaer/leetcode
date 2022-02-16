package twoPointer;

import java.util.Arrays;

public class P1099_TwoSumLessThanK {
	public int twoSumLessThanK(int[] nums, int k) {
		int result = -1;
		if (nums.length < 2) {
			return result; 
		}
		
		Arrays.sort(nums);
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum < k) {
				l++;
				result = Math.max(result, sum);
			} else {
				r--;
			}
		}
		return result;
    }
}
