package topK;

import java.util.Queue;
import java.util.Set;

public class P264_UglyNumber {
	//从堆里加入一个元素logn级别，取一个元素0（1），得到第n个丑数需要n个循环
	//一共是nlogn
	//堆空间和 哈希集合空间都不会超过n，所以空间是n
	public int nthUglyNumber(int n) {
		int[] factors = {2,3,5};
		Set<Long> set = new HashSet<>();
		Queue<Long> pq = new PriorityQueue<>();
		
		set.add(1L);
		pq.offer(1L);
		int ugly = 1;
		
		for (int i = 0; i < n; i++) {
            long cur = pq.poll();
			ugly = (int) cur;
			for (int factor : factors) {
				long next = cur * factor;
				if (!set.contains(next)) {
					set.add(next);
					pq.offer(next);
				}
			}
		}
		return ugly;
    }
}
