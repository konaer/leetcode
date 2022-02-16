package twoPointer;

import java.util.Arrays;

public class L587_TwoSumUniquePairs {
	public int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums.length <= 1 || nums == null) {
            return 0;
        }

        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        int ans = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                ans++;
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1]) {
                    l++;
                }
                while (l < r && nums[r] == nums[r + 1]) {
                    r--;
                }
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return ans;

    }
}
