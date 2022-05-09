package z;

import java.util.*;
// https://www.1point3acres.com/bbs/thread-889914-1-1.html
public class rhombic {
	
	private static final int[] dir = {1, 0, -1, 0, 1};
	
	public static int[] find(int[][] matrix, int radius) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int num = bfs(matrix, i, j, radius);
//				System.out.println(i + ":" + j + ");
				System.out.println(num);
				if (num != -1) {
					pq.offer(num);
					if (pq.size() > 3) {
						pq.poll(); 
					}
				}
			}
		}
		int[] ans = new int[pq.size()];
		for (int i = pq.size() - 1; i >= 0; i--) {
			ans[i] = pq.poll();
		}
		return ans;
	}
	
	private static int bfs(int[][] matrix, int i, int j, int k) {
		int m = matrix.length, n = matrix[0].length;
		Queue<Integer> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];
		queue.offer(i * n + j);
		System.out.println("");
		System.out.println(i + ":" + j);
		System.out.println("___________");
		visited[i][j] = true;
		while (k != 1 && !queue.isEmpty()) {
			int size = queue.size();
			for (int a = 0; a < size; a++) {
				int point = queue.poll();
				int x = point / n;
				int y = point % n;
				for (int b = 0; b < dir.length - 1; b++) {
					int nx = x + dir[b];
					int ny = y + dir[b + 1];
					System.out.println(nx + ";" + ny);
					if (!isValid(matrix, nx, ny)) {
						return -1;
					}
					if (!visited[nx][ny]) {
						queue.offer(nx * n + ny);
						visited[nx][ny] = true;
					}					
				}
			}
			k--;
		}
		int ans = 0;
		while(!queue.isEmpty()) {
			int point = queue.poll();
			ans += matrix[point / n][point % n];
		}
		return ans;
	}
	
	private static boolean isValid(int[][] matrix, int i, int j) {
		if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
			return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		int[][] matrix = {{1,1,2,2,0,2,1}, {2,0,2,3,3,2,2}, {1,2,1,3,0,2,2}, {0,1,0,0,1,1,3}, {1,1,1,2,3,2,1}, {2,2,1,0,1,0,0}, {0,3,3,3,3,2,1}, {0,1,1,1,1,0,3}};
		int radius = 3;
		int ans[] = find(matrix, radius);
		System.out.println(Arrays.toString(ans));
	}
}
