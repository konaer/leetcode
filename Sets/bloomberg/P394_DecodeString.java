package z;

import java.util.Deque;

public class P394_DecodeString {
	//time n n是string 长度
	//space n
	public String decodeString(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (c != ']') {
				stack.push(c);
			} else {
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
					sb.insert(0, stack.pop());
				}
				String sub = sb.toString();
				stack.pop();
				
				sb.setLength(0);
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					sb.insert(0, stack.pop());
				}
				int num = Integer.parseInt(sb.toString());
				while (num > 0) {
					for (char ch : sub.toCharArray()) {
						stack.push(ch);
					}
					num--;
				}
			}
		}
		
		StringBuilder ans = new StringBuilder();
		while (!stack.isEmpty()) {
			ans.insert(0, stack.pop());
		}
		return ans.toString();
    }
}
