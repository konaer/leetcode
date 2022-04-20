package z;

import java.util.*;

public class N1091_ShortestPathinBinaryMatrix {
	public static int find(int[][] grid) {
		int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
		int m = grid.length;
		int n = grid[0].length;
		
		if (grid[0][0] == 0){
			return -1;
		}
		
		
		boolean[][] vis = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		int dis = 0;
		
		queue.offer(new int[]{0,0});
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int c = 0; c < size; ++c) {
				int[] poll = queue.poll();
				int i = poll[0];
				int j = poll[1];
				for (int k = 0; k < 4; ++k) {
					int ni = i + dir[k][0];
					int nj = j + dir[k][1];
					System.out.println("ni:" + ni + "nj" + nj);
					if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] != 0 && !vis[ni][nj]) {
						if (grid[ni][nj] == 9) {
							return dis + 1;
						}
						queue.offer(new int[]{ni, nj});
						vis[ni][nj] = true;
					}
				}
			}
			dis++;
			System.out.println("_________________");
			System.out.println(dis);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,0}, {1,0,0}, {1,9,1}};
		System.out.println(find(grid));
	}
}
