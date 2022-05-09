package z;

import java.util.HashMap;
import java.util.Map;

public class longestSubstring {
	public static String find(String s) {
		String ans = "";
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				String sub = s.substring(i, j + 1);
				if (isValid(sub) && sub.length() > ans.length()) {
					ans = sub;
				}
			}
		}
		return ans;
	}
	
	public static boolean isValid(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int target = map.get(s.charAt(0));
		for (int num : map.values()) {
			if (target != num) {
				return false;
			}
		}
		return true;
	} 
	
	public static void main(String[] args) {
		String s = "aabbccmedf";
		System.out.println(find(s));
	}
}
