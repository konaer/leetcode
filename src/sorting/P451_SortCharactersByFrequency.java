package sorting;

import java.util.List;
import java.util.Map;

public class P451_SortCharactersByFrequency {
	
	//bucket sort
	//时间o(n+k)， n为字符串长度， k是不同字符个数
	//遍历统计频率n时间， 创建桶K时间，遍历桶k时间，拼接字符串n时间
	
	//空间o(n + k)
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			count = map.getOrDefault(c, 0) + 1;
			map.put(c, count);
		}
		
		//list的index是某一个char的数量，那么最后一个index应该
		//正好是string的长度，所以list的长度是 string长度 + 1
		List<Character>[] bucket = new List[s.length() + 1];
		for (char key : map.keySet()) {
			int count = map.get(key);
			if (bucket[count] == null) {
				bucket[count] = new ArrayList<>();
			}
			bucket[count].add(key);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != null) {
				for (char c : bucket[i]) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
    }
}
