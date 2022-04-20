package z;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidString {
	public static boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		char [] arr = s.toCharArray();
		for (char c : arr) {
			if(stack.isEmpty() || c!=stack.peekFirst()) {
				stack.push(c);
			}else if(c==stack.peekFirst()) {
				stack.pop();
			}
		}
		
		return stack.isEmpty();
	} 
	
	public static void main(String[] args) {
		
	}
}
