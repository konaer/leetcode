package backtrack;

import java.util.List;

public class P131_PalindromePartition {
	
	// 分割时间 2^n ， 检查是否回文时间 n,总共为n*2^n;
	// 空间为栈空间 n层
	
	List<List<String>> ans = new ArrayList<>();
	List<String> list = new ArrayList<>();
	
	public List<List<String>> partition(String s) {
		dfs(s, 0);
		return ans;
    }
	
	private void dfs(String s, int index) {
		if (index == s.length()) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = index; i < s.length(); i++) {
			String subString = s.substring(index, i + 1);
			if (!isPalindrome(subString)) {
				continue;
			}
			list.add(subString);
			dfs(s, i + 1);
			list.remove(list.size() - 1);
		}
	}
	
	private boolean isPalindrome(String s) {
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (s.charAt(l++) != s.charAt(r--)) {
				return false;
			}
		}
		return true;
	}
}
