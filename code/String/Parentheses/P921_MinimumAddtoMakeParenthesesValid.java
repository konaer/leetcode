package String;

public class P921_MinimumAddtoMakeParenthesesValid {
	//time n
	//space 1
	public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                right++;
            }
            if (c == ')') {
                if (right > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return left + right;
    }
}
