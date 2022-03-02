package String;

import java.util.Deque;

public class P32_LongestValidParentheses {
	//time n
	//space n
	public int longestValidParentheses(String s) {
       int ans = 0;
       Deque<Integer> stack = new ArrayDeque<>();
       stack.push(-1);
       for (int i = 0; i < s.length(); i++) {
    	   if (s.charAt(i) == '(') {
    		   stack.push(i);
    	   } else {
    		   stack.pop();
    		   //注意这里有哨兵节点，所以pop之后如果是空，就证明
    		   //这个闭括号已经是一个无效的了，所以直接把i入栈
    		   if (stack.isEmpty()) {
    			   stack.push(i);
    		   } else {
    			   ans = Math.max(ans, i - stack.peek());
    		   }
    	   }
       }
       return ans;
    }
}
