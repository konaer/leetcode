package z;

public class P647_PalindromicSubstrings {
	//time n^2
	//space 1
	private int count = 0;
	
	public int countSubstrings(String s) {
		if (s.length() == 0) {
			return 0;
		}
		
		for (int i = 0; i < s.length(); i++) {
			helper(s, i, i);
			helper(s, i, i + 1);
		}
		return count;
    }
	
	private void helper(String s, int left, int right) {
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				count++;
				left--;
				right++;
			} else {
				break;
			}
		}
	}
}
