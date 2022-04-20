package simulation;

public class P1275_FindWinneronaTicTacToeGame {
	//time moves.length
	//space n
	public String tictactoe(int[][] moves) {
        int n = 3;
        int player = 1;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int dia = 0, adia = 0;
        
        
        for (int[] move : moves) {
            int i = move[0];
            int j = move[1];
            
            rows[i] += player;
            cols[j] += player;
            
            if (i == j) {
                dia += player;
            }
            
            if ((i + j) == (n- 1)) {
                adia += player;
            }
            
            if (Math.abs(rows[i]) == n || Math.abs(cols[j])  == n || Math.abs(dia) == n || Math.abs(adia) == n) {
                return player == 1 ? "A" : "B";
            }
            player *= -1;
        }
        if (moves.length == n * n) {
            return "Draw";
        } else {
            return "Pending";
        }
    }
}
