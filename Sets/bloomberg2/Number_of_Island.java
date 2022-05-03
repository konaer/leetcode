package dfs;

public class P200_Number_of_Island {
    public int numIslands(char[][] grid) {
        int result = 0;
    	if (grid == null) {
        	return result;
        }
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == '1') {
    				dfs(grid, i, j);
    				result++;
    			}
    		}
    	}
    	return result;
    }
    
    private void dfs(char[][] grid, int i, int j) {
    	if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
    		return;
    	}
    	grid[i][j] = '0';
    	dfs(grid, (i - 1), j);
    	dfs(grid, (i + 1), j);
    	dfs(grid, i, (j - 1));
    	dfs(grid, i, (j + 1));
    }
}