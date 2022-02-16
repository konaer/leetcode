package monotoneStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class P402_RemoveKDigits {
	public String removeKdigits(String num, int k) {
		//时间 n
		//空间 deque空间，最多是n
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
        	while (!deque.isEmpty() && c < deque.peekLast() && k > 0) {
        		deque.pollLast();
        		k--;
        	}
        	deque.offerLast(c);
        }
        
        while (k > 0) {
        	deque.pollLast();
        	k--;
        }
        
        //注意这里是char， 0 的部分要加引号
        while (!deque.isEmpty() && deque.peekFirst() == '0') {
            	deque.pollFirst();
            }
        
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
        	
        	sb.append(deque.pollFirst());
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
