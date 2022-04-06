package z;

import java.util.Arrays;

public class P1220_CountVowelsPermutation {
	//time n
	//space l
	public int countVowelPermutation(int n) {
		long mod = 1000000007;
		long[] dp = new long[5];
		long[] ndp = new long[5];
		
		Arrays.fill(dp, 1);
		for (int i = 2; i <= n; ++i) {
            /* a前面可以为e,u,i */
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            ndp[1] = (dp[0] + dp[2]) % mod;
            ndp[2] = (dp[1] + dp[3]) % mod;
            ndp[3] = dp[2];
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }
		long ans = Arrays.stream(dp).sum() % mod;
		return (int) ans;
	}
}
