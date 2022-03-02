package String;

import java.util.Deque;
import java.util.Set;

public class P1249_MinimumRemovetoMakeValidParentheses {
	public String minRemoveToMakeValid(String s) {
        Set<Integer> set = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            }
            if (c == ')') {
                if (stack.size() == 0) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        while (!stack.isEmpty()) {
        	set.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        	if (set.contains(i)) {
        		continue;
        	}
        	sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
