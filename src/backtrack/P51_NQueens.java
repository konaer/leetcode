package backtrack;

import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer;

public class P51_NQueens {
	
	//时间n!, 第一层n种可能，第二层n-1种，依次减少。
	//判断isvalid时间是o(1)
	//递归栈空间n
	
//    List<List<String>> ans = new ArrayList<>();
//    Set<Integer> col = new HashSet<>();
//    Set<Integer> dias1 = new HashSet<>();
//    Set<Integer> dias2 = new HashSet<>(); 
//
//    public List<List<String>> solveNQueens(int n) {
//        int[] queens = new int[n];
//        backtrack(queens, n, 0);
//        return ans;
//    }
//
//    private void backtrack(int[] queens, int n, int row) {
//        if (row == n) {
//            List<String> board = generateBoard(queens, n);
//            ans.add(board);
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            if (isValid(row, i)) {
//                queens[row] = i;
//                col.add(i);
//                dias1.add(row + i);
//                dias2.add(row - i);
//                backtrack(queens, n, row + 1);
//                col.remove(i);
//                dias1.remove(row + i);
//                dias2.remove(row - i);
//            }
//        }
//    }
//
//    private boolean isValid(int row, int i) {
//        if (col.contains(i) || dias1.contains(row + i) || dias2.contains(row - i)) {
//            return false;
//        }
//        return true;
//    }
//
//    private List<String> generateBoard(int[] queens, int n) {
//        List<String> board = new ArrayList<>();
//        
//        for (int i = 0; i < n; i++) {
//            char[] chars = new char[n];
//            Arrays.fill(chars, '.');
//            chars[queens[i]] = 'Q';
//            board.add(new String(chars));
//        }
//        return board;
//    }
	
	List<List<String>> results = new ArrayList<>();	
	public List<List<String>> solveNQueens(int n)  {
		char[][] board = new char[n][n];
		for (char[] row : board) {
			Arrays.fill(row, '.');
		}
		backtrack(board, n, 0);
		return results;
	}
	
	private void backtrack(char[][] board, int n, int row) {
		if (row == n) {
			List<String> result = generateRes(board);
			results.add(result);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (isValid(board, n, row, i)) {
				board[row][i] = 'Q';
				backtrack(board, n, row + 1);
				board[row][i] = '.';
			}
		}
	}
	
	private boolean isValid(char[][] board, int n, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (board[i][col] == 'Q') return false;
			if (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') return false;
			if (col + (row - i) < n && board[i][col + (row - i)] == 'Q') return false;
		}
		return true;
	}
	
	private List<String> generateRes(char[][] board) {
		List<String> result = new ArrayList<>();
		for (char[] row : board) {
			result.add(new String(row));
		}
		return result;
	}
}
