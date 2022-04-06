package z;

public class P79_wordSearch {
	//time mn*3^l, l是字符串长度
	//space mn
	int[] directions = { 1, 0, -1, 0, 1 };
	boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		int m = board.length, n = board[0].length;
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, i, j, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(char[][] board, String word, int i, int j, int k) {
		if (board[i][j] == word.charAt(k)) {
			if (k == word.length() - 1) {
				return true;
			}

			visited[i][j] = true;
			for (int t = 0; t < directions.length - 1; t++) {
				int ni = i + directions[t];
				int nj = j + directions[t + 1];
				if (isValid(board, ni, nj) && !visited[ni][nj] && dfs(board, word, ni, nj, k + 1)) {
					return true;
				}
			}
			visited[i][j] = false;
		}
		return false;
	}

	private boolean isValid(char[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
			return false;
		}
		return true;
	}
}
