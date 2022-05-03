package z;

public class N723_CandyCrush {
	public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean todo = false;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j + 2 < n; ++j) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i][j+1]) && v == Math.abs(board[i][j+2])) {
                    board[i][j] = board[i][j+1] = board[i][j+2] = -v;
                    todo = true;
                }
            }
        }
        for (int i = 0; i + 2 < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int v = Math.abs(board[i][j]);
                if (v != 0 && v == Math.abs(board[i+1][j]) && v == Math.abs(board[i+2][j])) {
                    board[i][j] = board[i+1][j] = board[i+2][j] = -v;
                    todo = true;
                }
            }
        }

        for (int k = 0; k < n; ++k) {
            int index = m - 1;
            for (int r = m-1; r >= 0; --r)
                if (board[r][k] > 0)
                    board[index--][k] = board[r][k];
            while (index >= 0)
                board[index--][k] = 0;
        }

        return todo ? candyCrush(board) : board;
    }
}
