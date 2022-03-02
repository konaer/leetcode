package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class P856_ScoreOfParentheses {
	public int scoreOfParentheses(String s) {
		//time n
		//space, stack space, n
		Deque<Integer> stack = new ArrayDeque<>();
		int cur = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(cur);
				cur = 0;
			} else {
				cur = stack.pop() + Math.max(cur * 2, 1);
			}
		}
		return cur;)
    }
}
