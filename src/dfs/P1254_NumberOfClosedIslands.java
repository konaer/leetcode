package dfs;

public class P1254_NumberOfClosedIslands {
	//time 遍历时间 m * n
	//space stack space, m * n
	private int m, n;
	
	public int closedIsland(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int ans = 0;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0 && dfs(grid, i, j)) {
					ans++;
				}
			}
		}
		return ans;
    }
	
	private boolean dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}
		if (grid[i][j] == 1) {
			return true;
		}
		
		grid[i][j] = 1;
		return dfs(grid, i + 1, j) 
				& dfs(grid, i - 1, j) 
				& dfs(grid, i, j + 1) 
				& dfs(grid, i, j - 1); 
	}
}
