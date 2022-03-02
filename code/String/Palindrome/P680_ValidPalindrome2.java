package twoPointer;

public class P680_ValidPalindrome2 {
	//time n
	//space 1
	public boolean validPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				return isValid(s, left + 1, right) || isValid(s, left, right - 1);
			}
		}
		return true;
    }
	
	private boolean isValid(String s, int left, int right) {
		while (left < right) {
			if (s.charAt(left++) != s.charAt(right--)) {
				return false;
			}
		}
		return true;
	} 
}
