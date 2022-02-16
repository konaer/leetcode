package SlidingWindow;

import java.util.*;

public class P3_LongestSubstringWithoutRepeatingCharacters {
	
	//o(n) 最坏的情况，两个指针都遍历一遍，2n，还是n
	//空间，set里最多，看有多少个字符了。
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		Set<Character> set = new HashSet<>();
		int l = 0, r = 0, ans = 0;
		while (r < s.length()) {
			char c = s.charAt(r);
			while (set.contains(c)) {
				set.remove(s.charAt(l++));
			}
			set.add(c);
			r++;
			ans = Math.max(ans, set.size());
		}
		return ans;
	}
}
