package z;

import java.util.HashMap;
import java.util.Map;

public class Better2 {
	public static int find(int[] nums) {
		int l = 0, r = 0;
		int ans = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		while (r < nums.length) {
			map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
			r++;
			while (map.keySet().size() > 2) {
				map.put(nums[l], map.get(nums[l]) - 1);
				if (map.get(nums[l]) == 0) {
					map.remove(nums[l]);
				}
				l++;
			}
			ans = Math.max(ans, r - l);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,4};
		System.out.println(find(nums));
	}
}
