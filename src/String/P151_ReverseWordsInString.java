package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P151_ReverseWordsInString {
	//time n
	//space n
	public String reverseWords(String s) {
		//注意题目要求返回时无论几个空格都只保留一个，所以用正则表达式
		String[] ns = s.trim().split("\\s+");
		List<String> list = Arrays.asList(ns);
		Collections.reverse(list);
		return String.join(" ", ns);
    }
}
