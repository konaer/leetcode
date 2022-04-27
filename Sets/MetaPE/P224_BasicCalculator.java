package String;

import java.util.Deque;

public class P224_BasicCalculator {
	//time travseral o(n)
	//space stack space, n
	private int i = 0;
	
	public int calculate(String s) {
		Deque<Integer> stack = new ArrayDeque<>();
		char ops = '+';
		int num = 0;
		while (i < s.length()) {
			char c = s.charAt(i++);
			if (c >= '0' && c <= '9') {
				num = num * 10 + (c - '0');
			}
			if (c == '(') {
				num = calculate(s);
			}
			if (i == s.length() || c == '+' || c == '-' || c == ')') {
				if (ops == '+') {
					stack.push(num);
				}
				if (ops == '-') {
					stack.push(-num);
				}
				ops = c;
				num = 0;
			}
			
			if (c == ')') {
				break;
			}
		}
		return stack.stream().mapToInt(i -> i).sum();
	}
}
