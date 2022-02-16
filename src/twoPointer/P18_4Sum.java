package twoPointer;

import java.util.*;

public class P18_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		if (nums == null && nums.length < 4) {
			return ans;
		}
		
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
				break;
			}
			if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) {
				continue;
			}
			//j从i+ 1开始就可以了
			for (int j = i + 1; j < n -2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				if ((long)nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
					break;
				}
				if ((long)nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) {
					continue;
				}
				int l = j + 1, r = n - 1;
				while (l < r) { 
					int sum = nums[i] + nums[j] + nums[l] + nums[r];
					if (sum == target) {
						List<Integer> list = List.of(nums[i], nums[j], nums[l++], nums[r--]);
						ans.add(list);
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
			}
		}
		return ans;
    }
}
