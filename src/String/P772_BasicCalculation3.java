package String;

public class P772_BasicCalculation3 {
	//time n
	//space n
	int i = 0;

    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        char ops = '+';
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }

            if (c == '(') {
                num = calculate(s);
            }

            if (i == s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')') {
                if (ops == '+') {
                    stack.push(num);
                } else if (ops == '-') {
                    stack.push(-num);
                } else if (ops == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                ops = c;
                num = 0;
            }

            if (c == ')') {
                break;
            }
        }
        return stack.stream().mapToInt(x -> x).sum();
    }
}
