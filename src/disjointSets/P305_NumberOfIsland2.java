package disjointSets;

import java.util.ArrayList;
import java.util.List;

public class P305_NumberOfIsland2 {

	// O(klog(mn))
	// O(m×n)

	private final static int[][] DIRECTION = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		UnionFind uf = new UnionFind(m * n);
		boolean[] visited = new boolean[m * n];
		int count = 0;

		List<Integer> result = new ArrayList<>();
		for (int[] position : positions) {
			int x = position[0];
			int y = position[1];
			int index = x * n + y;

			// 注意此处要先判断有没有被统计过，因为可能给两个完全一样的坐标给你。
			if (!visited[index]) {
				count++;
				visited[index] = true;
				for (int[] direction : DIRECTION) {
					int nx = x + direction[0];
					int ny = y + direction[1];
					int nIndex = nx * n + ny;

					if (isValid(nx, ny, m, n) && visited[nIndex] && !uf.isConnected(index, nIndex)) {
						uf.union(index, nIndex);
						count--;
					}
				}
			}
			result.add(count);
		}
		return result;
	}

	private boolean isValid(int x, int y, int m, int n) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}

	private class UnionFind {
		private int[] parent;
		private int[] rank;

		public UnionFind(int n) {
			this.parent = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				rank[i] = 0;
			}
		}

		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}

		public int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}

		public void union(int x, int y) {
			int i = find(x);
			int j = find(y);
			if (i == j) {
				return;
			}
			if (rank[i] < rank[j]) {
				parent[i] = j;
			} else if (rank[i] > rank[j]) {
				parent[j] = i;
			} else {
				parent[i] = j;
				rank[j]++;
			}
		}
	}
}
