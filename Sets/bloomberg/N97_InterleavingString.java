package z;

public class N97_InterleavingString {
	public static boolean isInterleave(String str1, String str2, String str3) {
        int n = str1.length();
        int m = str2.length();
        if (str3.length() != n + m) return false;
        // dp[i][j]：s1前缀长度i + s2前缀长度j，能否交错组成s3前缀长度i+j
        boolean[][] dp = new boolean[n+1][m+1];
        char[] s1 = str1.toCharArray(), s2 = str2.toCharArray(), s3 = str3.toCharArray();
        dp[0][0] = true;
        // 第0行：s1前缀长度0 + s2前缀长度i，能否交错组成s3前缀长度i
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i-1] && s2[i - 1] == s3[i - 1];
        }
        // 第0列：s1前缀长度i + s2前缀长度0，能否交错组成s3前缀长度i
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i-1][0] && s1[i - 1] == s3[i - 1];
        }
        // 普通位置 dp[i][j]：s1前缀长度i + s2前缀长度j，能否交错组成s3前缀长度i+j
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 考虑s3的最后一个字符s3[i+j-1]来自哪里？做状态转移：
                // 1）如果来自s1[i-1]，则dp[i][j] 为：s1前缀长度i-1 + s2前缀长度j 能否交错组成s3前缀长度i+j-1，即：dp[i-1][j]
                // 2）如果来自s2[j-1]，则dp[i][j] 为：s1前缀长度i + s2前缀长度j-1 能否交错组成s3前缀长度i+j-1，即：dp[i][j-1]
                dp[i][j] = (s1[i-1] == s3[i+j-1] && dp[i-1][j]) ||
                           (s2[j-1] == s3[i+j-1] && dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}

