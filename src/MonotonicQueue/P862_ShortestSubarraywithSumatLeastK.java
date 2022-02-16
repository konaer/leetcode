package MonotonicQueue;

import java.util.Deque;

public class P862_ShortestSubarraywithSumatLeastK {
	//时间 n
	//空间 n
	public int shortestSubarray(int[] nums, int k) {
		int n = nums.length;
		int ans = n + 1;
		
		long[] sums = new long[n + 1];
		for (int i = 0; i < n; i++) {
			sums[i + 1] = sums[i] + nums[i];
		}
		
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < n + 1; i++) {
			while (!q.isEmpty() && sums[i] - sums[q.peekFirst()] >= k) {
				ans = Math.min(ans, i - q.pollFirst());
			}
			while (!q.isEmpty() && sums[i] <= sums[q.peekLast()]) {
				q.pollLast();
			}
			q.offerLast(i);
		}
		return ans > n ? -1 : ans;
    }
}
