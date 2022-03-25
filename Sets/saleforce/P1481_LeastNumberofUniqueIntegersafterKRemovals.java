package z;

import java.util.Map;
import java.util.PriorityQueue;

public class P1481_LeastNumberofUniqueIntegersafterKRemovals {
	//time nlogn
	//space n
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
		for (int num : map.keySet()) {
			heap.offer(num);
		}
		
		while (heap.size() > 0) {
			k -= map.get(heap.poll());
			if (k == 0) {
				return heap.size();
			}
			if (k < 0) {
				return heap.size() + 1;
			}
		}
		return 0;
    }
}
