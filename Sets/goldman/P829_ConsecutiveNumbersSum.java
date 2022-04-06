package z;

public class P829_ConsecutiveNumbersSum {
	//time 根号n
	//space 1
	public int consecutiveNumbersSum(int N) {
        // 2N = k(2x + k + 1)
        int ans = 0;
        for (int k = 1; k <= Math.sqrt((double) 2 * N); k++) {
            if (2 * N % k == 0) {
                int y = 2 * N / k - k - 1;
                if (y % 2 == 0 && y >= 0)
                    ans++;
            }
        }
        return ans;
    }
}
