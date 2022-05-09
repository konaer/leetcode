package simulation;

public class P1801_NumberOfOrdersInTheBacklog {
	//time nlogn
	private final int mod = 1000000007;

	public int getNumberOfBacklogOrders(int[][] orders) {
		PriorityQueue<int[]> buys = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		PriorityQueue<int[]> sells = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int[] order : orders) {
			if (order[2] == 0) {
				buys.offer(order);
			} else {
				sells.offer(order);
			}
			while (!sells.isEmpty() && !buys.isEmpty() && sells.peek()[0] <= buys.peek()[0]) {
				int k = Math.min(sells.peek()[1], buys.peek()[1]);
				sells.peek()[1] -= k;
				buys.peek()[1] -= k;
				if (sells.peek()[1] == 0) {
					sells.poll();
				}
				if (buys.peek()[1] == 0) {
					buys.poll();
				}
			}
		}
		int ans = 0;
		while (!sells.isEmpty()) {
			ans += sells.poll()[1];
			ans %= mod;
		}
		while (!buys.isEmpty()) {
			ans += buys.poll()[1];
			ans %= mod;
		}
		return ans;
	}
}
