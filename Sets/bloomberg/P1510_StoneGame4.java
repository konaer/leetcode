package z;

public class P1510_StoneGame4 {
	//n*根号n
	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j * j <= i; j++) {
        		if (!dp[i - j * j]) {
        			dp[i] = true;
        			break;
        		}
        	}
        }
        return dp[n];
    }
}
