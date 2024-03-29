package disjointSets;

public class P261_GraphValidTree {
	//时间， 带rank的unionfind 操作一次近似为常数，按照logn算
	//所以总的是 klogn
	//并查集需要的空间是n
	public boolean validTree(int n, int[][] edges) {
        int count = n;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
            count--;
        }
        return count == 1;
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

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
