package hashTable;

import java.util.*;

public class P49_GroupAnagram {
	//时间复杂度 o( nklogk ) n个遍历，每一个排序时间klogk
	//空间o(nk) 哈希表储存n个，每个要k长度。
	 public List<List<String>> groupAnagrams(String[] strs) {
		 Map<String, List<String>> map = new HashMap<>();
		 for (String str : strs) {
			 char[] array = str.toCharArray();
			 Arrays.sort(array);
			 String key = new String(array);
			 map.computeIfAbsent(key, k -> new ArrayList<>());
			 map.get(key).add(str);
		 }
		 return new ArrayList<>(map.values());
	 }
	
	//第二种做法
	// 时间复杂度 o(n(k + t)) t是字符集
	//空间 0(n(k + t))
//	public List<List<String>> groupAnagrams(String[] strs) {
//		Map<String, List<String>> map = new HashMap<>();
//		for (String str : strs) {
//			int[] count = new int[26];
//			for (int i = 0; i < str.length(); i++) {
//				count[str.charAt(i) - 'a']++;
//			}
//			
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; i < count.length; i++) {
//				if (count[i] != 0) {
//					//注意这里要变成char！！！
//					sb.append((char)('a' + i)).append(count[i]);
//				}	
//			}
//			String key = sb.toString();
//			map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
//		}
//		return new ArrayList<>(map.values());
//	}
	
}
