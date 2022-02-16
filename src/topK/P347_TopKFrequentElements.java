package topK;

import java.util.Map;
import java.util.PriorityQueue;

public class P347_TopKFrequentElements {
	//时间 nlogk
	//空间 n + k, 取大的， n
	public int[] topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			int count = map.getOrDefault(num, 0) + 1;
			map.put(num, count);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return map.get(a) - map.get(b);
        });
		
		for (int num : map.keySet()) {
			pq.offer(num);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		
		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = pq.poll();
		}
		return ans;
    }
}
