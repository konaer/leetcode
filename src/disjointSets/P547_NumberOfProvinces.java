

package disjointSets;

import java.util.Queue;

public class P547_NumberOfProvinces {
	// 时间n^2
	// 空间n
	public int findCircleNum(int[][] isConnected) {
		int n = isConnected.length;
		UnionFind uf = new UnionFind(n);

		int count = n;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				//注意这里，需要先判断是否已经联通！！！
				if (isConnected[i][j] == 1 && !uf.connected(i, j)) {
					uf.union(i, j);
					count--;
				}
			}
		}
		return count;
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
			if (rank[i] > rank[j]) {
				parent[j] = i;
			} else if (rank[i] < rank[j]) {
				parent[i] = j;
			} else {
				parent[i] = j;
				rank[j]++;
			}
		}

		public boolean connected(int x, int y) {
			return find(x) == find(y);
		}
	}
}
