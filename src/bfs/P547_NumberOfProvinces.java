package bfs;

import java.util.Queue;

public class P547_NumberOfProvinces {
	//时间n^2
	//空间n
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		boolean[] visited = new boolean[n];
		Queue<Integer> queue = new LinkedList<>();
		
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				count++;
				queue.offer(i);
				while (!queue.isEmpty()) {
					int cur = queue.poll();
					for (int j = 0; j < n; j++)
				if (isConnected[cur][j] == 1 && !visited[j]) {
						queue.offer(j);
						visited[j] = true;						
					}
				}
			}
		}
		return count;
    }
}
