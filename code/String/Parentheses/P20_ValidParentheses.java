package String;

public class P20_ValidParentheses {
	
	//time n
	//space n
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || !stack.pop().equals(c)) {
                return false;
            }
        }
        return stack.isEmpty();
	}
}
