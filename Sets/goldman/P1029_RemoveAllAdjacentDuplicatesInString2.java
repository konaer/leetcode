package z;

public class P1029_RemoveAllAdjacentDuplicatesInString2 {
	public String removeDuplicates(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
	    Deque<Integer> pq = new ArrayDeque<>();
	    for (int i = 0; i < sb.length(); ++i) {
	        if (i == 0 || sb.charAt(i) != sb.charAt(i - 1)) {
	            pq.push(1);
	        } else {
	            int num = pq.pop() + 1;
	            if (num == k) {
	                sb.delete(i - k + 1, i + 1);
	                i = i - k;
	            } else {
	                pq.push(num);
	            }
	        }
	    }
	    return sb.toString();
    }
}
