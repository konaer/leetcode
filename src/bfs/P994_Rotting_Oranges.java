package bfs;

import java.util.*;

public class P994_Rotting_Oranges {
	//时间mn， bfs遍历
	//空间mn， queue的空间
	public int orangesRotting(int[][] grid) {
		if (grid == null) {
			return -1;
		}
		
		int m = grid[0].length;
		Queue<Integer> queue = new LinkedList<>();
		int fresh = 0;
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					queue.offer(i * m + j);
				} else if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}
		
		int[] xBias = {0, 0, 1, -1};
		int[] yBias = {1, -1, 0, 0};
		int result = 0;
		
		//如果有fresh=0就得停止，此时queue不一定为空，所以别忘了加这个条件
		while (!queue.isEmpty() && fresh != 0) {
			int size = queue.size();
			for (int t = 0; t < size; t++) {
				int num = queue.poll();
				int i = num / m;
				int j = num % m;
				for (int k = 0; k < xBias.length; k++) {
					int ni = i + xBias[k];
					int nj = j + yBias[k];
					if (isValid(grid, ni, nj)) {
						fresh--;
						queue.offer(ni * m + nj);
						grid[ni][nj] = 2;
					}
				}
			}
			result++;
		}
		return fresh == 0 ? result : -1;
    }
	
	private boolean isValid(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
			return false;
		}
		return true;
	}

}
