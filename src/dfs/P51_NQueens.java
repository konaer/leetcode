package dfs;

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
	
	List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        dfs(board, 0);
        return ans;
    }

    private void dfs(char[][] board, int row) {
        if (row == board.length) {
            ans.add(generateAns(board));
            return;
        }

        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                dfs(board, row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (j == col || row + col == i + j || row + j == i + col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> generateAns(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(new String(row));
        }
        return list;
    }
}
