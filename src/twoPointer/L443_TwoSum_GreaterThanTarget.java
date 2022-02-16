package twoPointer;

import java.util.Arrays;

public class L443_TwoSum_GreaterThanTarget {
	public int twoSum2(int[] nums, int target) {
		// write your code here
        int result = 0;
		if (nums.length < 2) {
			return result;
		}
		
        Arrays.sort(nums);
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int sum = nums[l] + nums[r];
			if (sum > target) {
				result += (r - l);
				r--;
			} else {
				l++;
			}
		}
		return result;
    }
}
