package bfs;

import java.util.Queue;
import java.util.Set;

public class P490_TheMaze {
	//时间遍历时间 m*n
	//space m*n, matrix and queue space
	int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
		//这里用set超时了
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(start);
		visited[start[0]][start[1]] = true;
		
		while (!queue.isEmpty()) {
			int[] point = queue.poll();
			if (point[0] == destination[0] && point[1] == destination[1]) {
				return true;
			}
			for (int[] dir : dirs) {
				int x = point[0] + dir[0];
				int y = point[1] + dir[1];
				while (isValid(maze, x, y)) {
					x += dir[0];
					y += dir[1];
				}
				x -= dir[0];
				y -= dir[1];
				if (!visited[x][y]) {
					visited[x][y] = true;
					queue.offer(new int[] {x, y});
				}
			}
		}
		return false;
    }
	
	private boolean isValid(int[][] maze, int x, int y) {
		if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] != 0) {
			return false;
		}
		return true;
	}
}
