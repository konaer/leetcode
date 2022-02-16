package monotoneStack;

import java.util.Deque;
import java.util.Set;

public class P316_RemoveDeuplicateLetters {
	//时间n, 三个循环
	//空间要看s的character种类数， 比如此题是26个英文字母
	public String removeDuplicateLetters(String s) {
		Deque<Character> stack = new LinkedList<>();
        Set<Character> visited = new HashSet<>();
        int[] last = new int[128];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i)] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!visited.add(c)) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peek() && i < last[stack.peek()]) {
                visited.remove(stack.pop());
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
