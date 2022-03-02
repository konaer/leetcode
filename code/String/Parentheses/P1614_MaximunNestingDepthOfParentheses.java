package String;

public class P1614_MaximunNestingDepthOfParentheses {
	//time n
	//space 1
	public int maxDepth(String s) {
		int ans = 0, count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
			}
			if (c == ')') {
				count--;
			}
			ans = Math.max(ans, count);
		}
		return ans;
    }
}
