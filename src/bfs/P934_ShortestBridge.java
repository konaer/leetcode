package bfs;

import java.util.Queue;

public class P934_ShortestBridge {
	//time mn
	//space mn

	private int[] directions = { -1, 0, 1, 0, -1 };

	public int shortestBridge(int[][] grid) {
		Queue<int[]> queue = new LinkedList<>();
		loop: for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					dfs(grid, queue, i, j);
					break loop;
				}
			}
		}

		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int size = queue.size();
			for (int t = 0; t < size; t++) {
				int[] point = queue.poll();
				for (int k = 0; k < directions.length - 1; k++) {
					int x = point[0] + directions[k];
					int y = point[1] + directions[k + 1];
					if (isValid(grid, x, y)) {
						if (grid[x][y] == 1) {
							return count;
						}
						if (grid[x][y] == 0) {
							grid[x][y] = 2;
							queue.offer(new int[] { x, y });
						}
					}
				}
			}
		}
		return count;
	}

	private void dfs(int[][] grid, Queue<int[]> queue, int i, int j) {
		if (!isValid(grid, i, j) || grid[i][j] == 2) {
			return;
		}
		if (grid[i][j] == 0) {
			queue.offer(new int[] { i, j });
			grid[i][j] = 2;
			return;
		}

		grid[i][j] = 2;
		for (int k = 0; k < directions.length - 1; k++) {
			dfs(grid, queue, i + directions[k], j + directions[k + 1]);
		}
	}

	private boolean isValid(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
			return false;
		}
		return true;
	}
}