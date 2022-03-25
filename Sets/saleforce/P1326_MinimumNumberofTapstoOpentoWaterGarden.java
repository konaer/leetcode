package z;

public class P1326_MinimumNumberofTapstoOpentoWaterGarden {
	//time n
	//space n
	public int minTaps(int n, int[] ranges) {
		int[] far = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int l = Math.max(0, i - ranges[i]);
			int r = Math.min(n, i + ranges[i]);
			far[l] = Math.max(far[l], r);
		}
		
		int maxPosition = 0, end = 0, ans = 0;
		for (int i = 0; i < n; i++) {
			maxPosition = Math.max(maxPosition, far[i]);
			if (i == end) {
				if (maxPosition <= i) {
					return -1;
				}
				end = maxPosition;
				ans++;
			}
		}
		return ans;
    }
}
