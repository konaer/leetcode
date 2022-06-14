package sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1636_SortArraybyIncreasingFrequency {
	//放入map，n时间，排序nlogn时间，总时间 nlogn
	//map和list空间 n
	public int[] frequencySort(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		for (int num : nums) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
			list.add(num);
		}
		
		Collections.sort(list, (a, b) -> {
			if (map.get(a) == map.get(b)) {
				return b - a;
			} else {
				return map.get(a) - map.get(b)
			}
		});
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = list.get(i);
		}
		return nums;
    }
}
