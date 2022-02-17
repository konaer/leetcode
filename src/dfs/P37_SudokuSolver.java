package dfs;

public class P37_SudokuSolver {
	//时间上限 9*9个格子，每个格子9中情况，所以是9^9*9
	//空间 栈空间 最多 9*9
	public void solveSudoku(char[][] board) {
		dfs(board);
	}
	
	private boolean dfs(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char c = '1'; c <= '9'; c++) {
						if (isValid(board, i, j, c)) {
							board[i][j] = c;
							if (dfs(board)) {
								return true;
							}
							board[i][j] = '.';
						}
					}
					return false;
				}
			}
		}
		return true;
    }
	
	private boolean isValid(char[][] board, int i, int j, char c) {
		for (int row = 0; row < board.length; row++) {
			if (board[row][j] == c) {
				return false;
			}
		}
		
		for (int col = 0; col < board[0].length; col++) {
			if (board[i][col] == c) {
				return false;
			}
		}
		
		for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++) {
			for (int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++) {
				if (board[row][col] == c) {
					return false;
				}
			}
		}	
		return true;
	}
}
