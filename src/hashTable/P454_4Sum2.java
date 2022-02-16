package hashTable;

import java.util.*;

public class P454_4Sum2 {
	//时间n^2，两个
	//空间哈希表里n^2个数，所以需要这么多空间。
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) {
			for (int j : nums2) {
				int sum = i + j;
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		for (int i : nums3) {
			for (int j : nums4) {
				int target = 0 - i - j;
				ans += map.getOrDefault(target, 0);
			}
		}
		return ans;
	}
}
