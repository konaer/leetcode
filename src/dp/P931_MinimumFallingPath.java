package dp;

public class P931_MinimumFallingPath {
	//time m*n
	//spack m*n
	public int minFallingPathSum(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = matrix[0][i];
		}
		
		for (int i = 1; i < m; i++) {
			dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]) + matrix[i][0];
			for (int j = 1; j < n - 1; j++) {
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j + 1])) + matrix[i][j];
			}
			dp[i][n - 1] = Math.min(dp[i - 1][n - 1], dp[i - 1][n - 2]) + matrix[i][n - 1];
			
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			ans = Math.min(ans, dp[m - 1][i]);
		}
		return ans;
    }
}
