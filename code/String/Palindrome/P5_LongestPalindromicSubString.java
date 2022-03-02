package z;

public class P5_LongestPalindromicSubString {
	//动态规划总数n^2, 每个状态转移时间为l，总时间为 n^2
	//空间， n^2
	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		int start = 0, end = 0;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
					if (end - start < j - i) {
						start = i;
						end = j;
					}
					dp[i][j] = true;
				}
			}
		}
		return s.substring(start, end + 1);
    }
	
	
	//中心扩散法
	//time n^2
	//space 1
	private StringBuilder sb = new StringBuilder();
	
	public String longestPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			helper(s, i, i);
			helper(s, i, i + 1);
		}
		return sb.toString();
	}
	
	private void helper (String s, int left, int right) {
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else {
				break;
			}
		}
		String cur = s.substring(left + 1, right);
		if (cur.length() > sb.length()) {
			sb.setLength(0);
			sb.append(cur);
		}
	}
	
}
