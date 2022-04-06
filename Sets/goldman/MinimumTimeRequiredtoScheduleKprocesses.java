package z;

import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/minimum-time-required-to-schedule-k-processes/amp/

public class MinimumTimeRequiredtoScheduleKprocesses {
	public static int minTime(int[] pros, int k) {
		int ans = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int pro : pros) {
			pq.offer(pro);
		}
		
		while (k > 0) {
			if (pq.isEmpty()) {
				return -1;
			}
			int p = pq.poll();
			k -= p;
			ans++;
			if (p / 2 != 0) {
				pq.offer(p / 2);
			}			
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] pros = {3,1,7,2,4};
		int k = 0;
		System.out.println(minTime(pros, k));
	}
}
