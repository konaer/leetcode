package z;

import java.util.*;

//https://www.1point3acres.com/bbs/thread-867183-1-1.html

public class NumberOfMoves {

	static int[][] dirs = { { 1, -2 }, { 1, 2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, -1 }, { -2, 1 } };

	public static int find(int n, int sr, int sc, int er, int ec) {
		int ans = 0;
		int end = er * n + ec;
		Set<Integer> set = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(sr * n + sc);
		set.add(sr * n + sc);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int num = queue.poll();
				int row = num / n;
				int col = num % n;
				if (row * n + col == end) {
					return ans;
				}
				for (int[] dir : dirs) {
					int nrow = row + dir[0];
					int ncol = col + dir[1];
					int nnum = nrow * n + ncol;
					if (!isValid(n, nrow, ncol) || set.contains(nnum)) {
						continue;
					}
					queue.offer(nnum);
					set.add(nnum);
				}
			}
			ans++;
		}
		return -1;
	}

	private static boolean isValid(int n, int i, int j) {
		if (i < 0 || i >= n || j < 0 || j >= n) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(find(6,5,5,0,5));
	}
}
