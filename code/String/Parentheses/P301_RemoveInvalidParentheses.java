package twoPointer;

import java.util.List;

public class P301_RemoveInvalidParentheses {
	//time n * 2^n
	//站深度n,每个深度需要n个空间储存字符串， 一共是 n^2
	private List<String> ans = new ArrayList<>();
	
	public List<String> removeInvalidParentheses(String s) {
		int lrm = 0, rrm = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				lrm++;
			} else if (c == ')') {
				if (lrm != 0) {
					lrm--;
				} else {
					rrm++;
				}
			}
		}
		dfs(s, 0, lrm, rrm);
		return ans;
    }
	
	private void dfs(String s, int start, int lrm, int rrm) {
		if (lrm == 0 && rrm == 0) {
			if (isValid(s)) {
				ans.add(s);
			}
			return;
		}
		
		for (int i = start; i < s.length(); i++) {
			if (i != start && s.charAt(i) == s.charAt(i - 1)) {
				continue;
			}
			
			if (lrm + rrm > s.length() - i) {
				return;
			}
			
			if (lrm > 0 && s.charAt(i) == '(') {
				dfs(s.substring(0, i) + s.substring(i + 1), i, lrm - 1, rrm);
			}
			if (rrm > 0 && s.charAt(i) == ')') {
				dfs(s.substring(0, i) + s.substring(i + 1), i, lrm, rrm - 1);
			}
		}
	}
	
	private boolean isValid(String s) {
		int left = 0, right = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				left++;
			} else if (c == ')') {
				left--;
				if (left < 0) {
					return false;
				}
			} 
		}
		return left == 0;
	}
}
