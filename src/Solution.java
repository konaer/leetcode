

import java.util.*;


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == '1') {
				dp[i][0] = 1;
			}
		}
		
		for (int i = 1; i < n; i++) {
			if (matrix[0][i] == '1') {
				dp[0][i] = 1;
			}
		}
		
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
				    ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		return ans * ans;
    }
    
    public static void main(String[] args) {
		
	}
}
