package disjointSets;

public class P323_NumberOfConnectedComponent {
	
	
	//klogn, K是操作的次数，也就是edges的数量，并查集初始化需要n的时间，
	//查询和合并需要 如果没有rank，需要logn时间，
	//有rank需要常数时间，这里近似认为是需要logn时间
	//空间 n,并查集需要的空间
	private int count;
	public int countComponents(int n, int[][] edges) {
		count = n;
		UnionFind uf = new UnionFind(n);
		
		for (int[] edge : edges) {
			if (uf.isConnected(edge[0], edge[1])) {
				continue;
			}
			uf.union(edge[0], edge[1]);
			count--;
		}
		return count;
	}
	
	private class UnionFind {
		private int[] parent;
		private int[] rank;
		
		public UnionFind(int x) {
			this.parent = new int[x];
			this.rank = new int[x];
			for (int i = 0; i < x; i++) {
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
			} else if (rank[j] > rank[i]) {
				parent[i] = j;
			} else {
				parent[i] = j;
				rank[j]++;
			}
		}
		
		public boolean isConnected(int x, int y) {
			return find(x) == find(y);
		}
	}
}
