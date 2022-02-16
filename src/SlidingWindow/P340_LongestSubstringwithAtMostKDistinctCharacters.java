package SlidingWindow;

import java.util.Map;

public class P340_LongestSubstringwithAtMostKDistinctCharacters {
	//时间n
	//空间k
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		int left = 0, right = 0, ans = 0;
		while (right < s.length()) {
			char cur = s.charAt(right++);
			map.put(cur, map.getOrDefault(cur, 0) + 1);
			while (map.size() > k) {
				char c = s.charAt(left++);
				map.put(c, map.get(c) - 1);
				if (map.get(c) == 0) {
					map.remove(c);
				}
			}
			ans = Math.max(ans, right - left);
		}
		return ans;
    }
}
