package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P15_3Sum {
	//时间排序 nlogn，遍历是 n^2，所以总体看是 n^2
	//空间是常数空间，不需要额外的空间
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return result;
		}
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				return result;
			}
			//注意这里是if，不能是while，每次只判断一个
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				int sum = nums[l] + nums[r] + nums[i];
				if (sum == 0) {
					//注意这里要移动指针！！
					result.add(List.of(nums[i], nums[l++],nums[r--]));
					while (l < r && nums[l] == nums[l - 1]) {
						l++;
					}
					while (l < r && nums[r] == nums[r + 1]) {
						r--;
					}
				} else if (sum > 0) {
					r--;
				} else {
					l++;
				}
			}
		}		
		return result;
    }
}
