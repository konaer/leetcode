package String;

import java.util.Deque;

public class P227_BasicCalculator2 {
	//time n
	//space n
	public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0, i = 0;
        char ops = '+';
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c >= '0' && c <= '9') {
            	num = num * 10 + (c - '0');
            }
            
            if (i == s.length() || c == '+' || c == '-' || c == '*' || c == '/') {
            	if (ops == '+') {
            		stack.push(num);
            	} else if (ops == '-') {
            		stack.push(-num);
            	} else if (ops == '*') {
            		stack.push(stack.pop() * num);
            	} else if (ops == '/') {
            		stack.push(stack.pop() / num);
            	}
            	ops = c;
            	num = 0;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}
