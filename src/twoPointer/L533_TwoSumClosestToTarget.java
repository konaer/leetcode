package twoPointer;

import java.lang.reflect.Array;
import java.util.Arrays;

public class L533_TwoSumClosestToTarget {
	public int twoSumClosest(int[] nums, int target) {
        // 这个题还可以用二分法，遍历i，用二分法找和i相加离target最近的数即可
        if (nums.length < 2) {
            return -1;
        }
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return 0;
            } else if (sum > target) {
                r--;
                ans = Math.min(ans, sum - target);
            } else {
                l++;
                ans = Math.min(ans, target - sum);
            }
        }
        return ans;
	}
}
