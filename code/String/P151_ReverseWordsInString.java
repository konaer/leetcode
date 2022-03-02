package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class P151_ReverseWordsInString {
	//time n
	//space n
	public String reverseWords(String s) {
		//注意题目要求返回时无论几个空格都只保留一个，所以用正则表达式
		s = s.trim();
        List<String> list = Arrays.asList(s.split("\\s+"));
        Collections.reverse(list);
        return String.join(" ", list);
    }
	
	//without API
	public String reverseWords(String s) {
		int left = 0, right = s.length() - 1;
		while (left <= right && s.charAt(left) == ' ') {
			left++;
		}
		while (left <= right && s.charAt(right) == ' ') {
			right--;
		}
		
		Deque<String> deque = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		
		while (left <= right) {
			char c = s.charAt(left++);
			if (sb.length() != 0 && c == ' ') {
				deque.offerFirst(sb.toString());
				sb.setLength(0);
			} else if (c != ' ') {
				sb.append(c);
			}
		}
		deque.offerFirst(sb.toString());
		
		return String.join(" ", deque);
	}
}
