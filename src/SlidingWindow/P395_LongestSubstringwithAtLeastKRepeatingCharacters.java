package SlidingWindow;

import java.util.Map;

public class P395_LongestSubstringwithAtLeastKRepeatingCharacters {
	//时间 外层 26，内层n，一共 26n
	//空间 map空间 字符串中包含的数字种类数，26
	public int longestSubstring(String s, int k) {
		int ans = 0;
		for (int i = 1; i <= 26; i++) {
			Map<Character, Integer> map = new HashMap<>();
			int left = 0, right = 0, count = 0;
			while (right < s.length()) {
				char c = s.charAt(right++);
				map.put(c, map.getOrDefault(c, 0) + 1);
				if (map.get(c) == k) {
					count++;
				}
				while (map.keySet().size() > i) {
					char leftChar = s.charAt(left++);
					if (map.get(leftChar) == k) {
						count--;
					}
					map.put(leftChar, map.get(leftChar) - 1);
					if (map.get(leftChar) == 0) {
						map.remove(leftChar);
					}
				}
				int size = map.keySet().size();
				if (size == i && size == count) {
					ans = Math.max(ans, right - left);
				}
			}
		}
		return ans;
	}
	
	
}
