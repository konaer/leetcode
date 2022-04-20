package z;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1805_NumberOfDifferentIntegersInAString {
	public int numDifferentIntegers(String word) {
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < sb.length(); i++) {
        	if (!Character.isDigit(sb.charAt(i))) {
        		sb.setCharAt(i, ' ');
        	} 
        }
        String nword = sb.toString();
        String[] nums = nword.trim().split("\\s+");
        
        Set<String> set = new HashSet<>();
        for (String num : nums) {
        	if (num != "") {	
        		set.add(deleteZero(num));
        	} 	
        }
        return set.size();
    }
	
	private String deleteZero(String num) {
		int i = 0;
		while (num.charAt(i) == '0' && i != num.length() - 1) {
			i++;
		}
		return num.substring(i);
	}
}
