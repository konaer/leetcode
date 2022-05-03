package String;

import java.util.ArrayDeque;
import java.util.Deque;

public class P856_ScoreOfParentheses {
	public int scoreOfParentheses(String s) {
		//time n
		//space, stack space, n
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		
		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(0);
			} else {
				int u = stack.pop();
				int v = stack.pop();
				stack.push(v + Math.max(u * 2, 1));
			}
		}
		return stack.pop();
	}
}
