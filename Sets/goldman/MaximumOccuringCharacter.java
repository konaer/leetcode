package z;

//https://www.1point3acres.com/bbs/thread-867738-1-1.html

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaximumOccuringCharacter {
	public static char find(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> {
			if (map.get(a) != map.get(b)) {
				return map.get(b) - map.get(a);
			} else {
				return s.indexOf(a) - s.indexOf(b);
			}
		});
		
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (char c : s.toCharArray()) {
			pq.offer(c);
		}
		
		return pq.peek();
	}
	
	public static void main(String[] args) {
		String s = "abbbaaccccc";
		System.out.println(find(s));
	}
	
	
}
