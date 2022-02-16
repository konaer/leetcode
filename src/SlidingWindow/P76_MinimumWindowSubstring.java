package SlidingWindow;

import java.util.Map;

public class P76_MinimumWindowSubstring {
	//
	public String minWindow(String s, String t) {
		//时间n
		//空间t的长度，m
		Map<Character, Integer> map = new HashMap<>();
		for (Character c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0, count = 0; 
		int minStart = 0, minLen = Integer.MAX_VALUE;
		while (right < s.length()) {
			char c = s.charAt(right++);
			if (map.containsKey(c)) {
				if (map.get(c) > 0) {
					count++;
				}
				map.put(c, map.get(c) - 1);
			}
			while (count == t.length()) {
				if (right - left < minLen) {
					minLen = right - left;
					minStart = left;
				}
				char leftChar = s.charAt(left++);
				if (map.containsKey(leftChar)) {
					map.put(leftChar, map.get(leftChar) + 1);
					if (map.get(leftChar) > 0) {
						count--;
					}
				}
			}			
		}
		if (minLen == Integer.MAX_VALUE) {
			return "";
		}
		return s.substring(minStart, minStart + minLen);
    }
}
