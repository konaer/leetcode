package disjointSets;

import java.util.Map;

public class P827_MakingALargeIsland {
	//time traversal n^2
	//space n^2
	class Solution {

	    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	    int n;
		
		public int largestIsland(int[][] grid) {
			n = grid.length;
			//注意这里是从1开始，否则[[1]]的情况考虑不进去
			int ans = 1;
			UnionFind uf = new UnionFind(n * n);
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 1) {
						for (int[] dir : dirs) {
							int x = i + dir[0];
							int y = j + dir[1];
							if (isValid(x, y) && grid[x][y] == 1) {
								uf.union(x * n + y, i * n + j);
							    ans = Math.max(ans, uf.size[uf.find(i * n + j)]);
							}
						}
					}
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (grid[i][j] == 0) {
						Map<Integer, Integer> map = new HashMap<>();
						for (int[] dir : dirs) {
							int x = i + dir[0];
							int y = j + dir[1];
							if (isValid(x, y) && grid[x][y] == 1) {
								int parent = uf.find(x * n + y);
							    map.put(parent, uf.size[parent]);
							}
						}
						int newAns = 1 + map.values().stream().mapToInt(k -> k).sum();
						ans = Math.max(ans, newAns);	
					}
				}
			}
			return ans;
	    }

	    private boolean isValid(int x, int y) {
	        if (x < 0 || y < 0 || x >= n || y >= n) {
	            return false;
	        }
	        return true;
	    }
		
		
		
		private class UnionFind {
			private int[] parent;
			private int[] size;
			
			public UnionFind(int n) {
				this.parent = new int[n];
				this.size = new int[n];
				for (int i = 0; i < n; i++) {
					parent[i] = i;
					size[i] = 1;
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
				parent[i] = j;
				size[j] += size[i];
			}
		}
	}
}