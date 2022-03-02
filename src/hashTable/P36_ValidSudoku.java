package hashTable;

public class P36_ValidSudoku {
	//时间 遍历时间n*m
	//空间 n*m
	public boolean isValidSudoku(char[][] board) {
		int[][] row = new int[9][9];
		int[][] col = new int[9][9];
		int[][][] grid = new int[3][3][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char c = board[i][j];
				if (c != '.') {
					//注意这里有个 -1， 因为 index范围是1~9，要把它换成 0~8
					//否则下面的index要越界了
					int index = c - '0' - 1;
					row[i][index]++;
					col[j][index]++;
					grid[i / 3][j / 3][index]++;
					if (row[i][index] > 1 || col[j][index] > 1 || grid[i / 3][j / 3][index] > 1) {
						return false;
					}
				}
			}
		}
		return true;
    }
}
