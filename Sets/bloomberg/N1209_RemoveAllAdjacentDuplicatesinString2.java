package z;

public class N1209_RemoveAllAdjacentDuplicatesinString2 {
	public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
	    Deque<Integer> stack = new ArrayDeque<>();
	    for (int i = 0; i < sb.length(); ++i) {
	        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	            stack.push(1);
	        } else {
	            int num = stack.pop() + 1;
	            if (num == k) {
	                sb.delete(i - k + 1, i + 1);
	                i = i - k;
	            } else {
	                stack.push(num);
	            }
	        }
	    }
	    return sb.toString();
    }
}
