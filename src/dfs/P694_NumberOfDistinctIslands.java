package dfs;

import java.util.Set;

public class P694_NumberOfDistinctIslands {
	//time mn
	//space mn
	public int numDistinctIslands(int[][] grid) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, sb, "b");
					set.add(sb.toString());
				}
			}
		}
		return set.size();
    }
	
	private void dfs(int[][] grid, int i, int j, StringBuilder sb, String s) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
			return;
		}
		sb.append(s);
		grid[i][j] = 0;
		dfs(grid, i + 1, j, sb, "u");
		dfs(grid, i - 1, j, sb, "d");
		dfs(grid, i, j + 1, sb, "l");
		dfs(grid, i, j - 1, sb, "r");
		//注意这个别忘了，否则只要大小一样，形状不一样的情况，就区别不出来了
		sb.append("e");
	}
}
