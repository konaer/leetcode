

package z;

import java.util.Deque;

public class P1209_RemoveAllAdjacentDuplicatesinString2 {
	public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
	    Deque<Integer> stack = new ArrayDeque<>();
	    for (int i = 0; i < sb.length(); ++i) {
	        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	            if (!stack.isEmpty() && stack.peek() > k) {
	            	int range = stack.pop();
	            	sb.delete(i - range + 1, i);
	            }
	        	stack.push(1);
	        } else {
	            int num = stack.pop() + 1;
	            stack.push(num);
	            }
	        }
	    }
	    return sb.toString();
    }
}


public String solution(String s, int k) {
	
	
}