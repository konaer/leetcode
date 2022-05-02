
import java.util.*;

class Solution {
    
	public static int find(String s, String target) {
		int i = 0, j = 3;
		int count = 0;
		while (j <= s.length()) {
			if (s.substring(i++, j++).equals(target)) {
				count++;
			}
		}
		return count;
	}
	
    public static void main(String[] args) {
    	String s = "abcbcbcaawe";
    	String target = "cbc";
    	System.out.println(find(s, target));
    }
    
}
