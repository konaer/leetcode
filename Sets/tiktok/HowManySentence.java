package z;
//https://www.chegg.com/homework-help/questions-and-answers/2-many-sentences-given-array-words-array-sentences-determine-words-anagrams--calculate-man-q83712807

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowManySentence {
	public static int[] find(String[] wordSet, String[] sentences) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : wordSet) {
			char[] arr = word.toCharArray();
			Arrays.sort(arr);
			String key = new String(arr);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		List<Integer> ans = new ArrayList<>();
		for (String sentence : sentences) {
			int count = 1;
			String[] words = sentence.split("\\s+");
			for (String word : words) {
				char[] arr = word.toCharArray();
				Arrays.sort(arr);
				String match = new String(arr);
				count *= map.getOrDefault(match, 1);
			}
			ans.add(count);
		}
		return ans.stream().mapToInt(i -> i).toArray();
	}
	
	public static void main(String[] args) {
		String[] wordSet = {"bats", "tabs", "in", "cat", "act"};
		String[] sentences= {"cat the bats", "in the act", "act tabs in"};
		
		int[] ans = find(wordSet, sentences);
		for (int num : ans) {
			System.out.println(num + " ");
		}
	}
}
