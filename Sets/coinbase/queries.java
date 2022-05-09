package z;

import java.util.*;
import java.util.Map;

public class queries {
	public static int[] solution(int[] a, int[] b, int[][] queries) {
		Map<Integer, Integer> map1 = new HashMap<>();
		Map<Integer, Integer> map2 = new HashMap<>();
		for (int num : a) {
			map1.put(num, map1.getOrDefault(num, 0) + 1);
		}
		for (int num : b) {
			map2.put(num, map2.getOrDefault(num, 0) + 1);
		}
		
		List<Integer> list = new ArrayList<>();
		for (int[] query : queries) {
			if (query[0] == 0) {
				int x = query[2];
				int y = a[query[1]];
				map1.put(x, map1.getOrDefault(x, 0) + 1);
				map1.put(y, map1.getOrDefault(y, 0) - 1);
			} else {
				int count = 0;
				int k = query[1];
				for (int i : map1.keySet()) {
					count += map1.get(i) * map2.getOrDefault(k - i, 0);
				}
				list.add(count);
			}
		}
		return list.stream().mapToInt(i ->i).toArray();
	}
	
	public static void main(String[] args) {
		int[] a = {3, 4};
		int[] b = {1,2,3};
		int[][] queries = {{1,5}, {0,0,1}, {1,5}};
		System.out.println(Arrays.toString(solution(a, b, queries)));
	}
}
