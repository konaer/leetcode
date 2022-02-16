package SlidingWindow;

import java.util.Map;

public class P992_SubarrayswithKDifferentIntegers {
	//时间n
	//空间 map空间 k
	public int subarraysWithKDistinct(int[] nums, int k) {
		return findMostK(nums, k) - findMostK(nums, k - 1);
    }
	
	private int findMostK(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int l = 0, r = 0, ans = 0;
		
		if (k == 0) {
			return 0;
		}
		
		while (r < nums.length) {
			int right = nums[r++];
			map.put(right, map.getOrDefault(right, 0) + 1);
			while (map.keySet().size() > k) {
				int left = nums[l++];
				map.put(left, map.get(left) - 1);
				if (map.get(left) == 0) {
					map.remove(left);
				}
			}
			//从{a, b, c} 走到d，增加了d,dc, dcb, cdba 四个结果。
			ans += r - l;
		}
		return ans;
	}
}
