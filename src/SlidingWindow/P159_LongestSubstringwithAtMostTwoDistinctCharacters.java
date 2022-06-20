package SlidingWindow;

import java.util.Map;

public class P159_LongestSubstringwithAtMostTwoDistinctCharacters {
	//时间n，遍历时间
	//hashmap空间，因为只有两个数，所以是 常数空间
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        
        while (right < s.length()) {
        	char cur = s.charAt(right++);
        	map.put(cur, map.getOrDefault(cur, 0) + 1);
        	while (map.size() > 2) {
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
