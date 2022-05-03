package z;

public class P204_countPrimes {
	//time n logn
	//space n
	public int countPrimes(int n) {
		int ans = 0;
		int[] prime = new int[n];
		Arrays.fill(prime, 1);
		for (int i = 2; i < n; i++) {
			if (prime[i] == 1) {
				ans++;
				if ((long)i * i < n) {
					for (int j = i * i; j < n; j += i) {
						prime[j] = 0;
					}
				}
			}
		}
		return ans;
	}    
}
