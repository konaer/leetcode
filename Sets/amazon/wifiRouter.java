package z;

//https://www.1point3acres.com/bbs/thread-797299-1-1.html

public class wifiRouter {
	public static int find(int[] building, int[] router, int[] range) {
		int n = building.length;
		int[] cover = new int[n];
		
		cover[0] = building[0];
		for (int i = 1; i < n; i++) {
			cover[i] = building[i] - building[i - 1];
		}
		
		for (int i = 0; i < router.length; i++) {
			int startIndex = Math.max(0, router[i] - range[i]);
			int endIndex = Math.min(0, router[i] + range[i]);
			
			cover[startIndex]++;
			if (endIndex < n - 1) {
				cover[endIndex]--;
			}
		}
		
		for (int i = 1; i < n; i++) {
			cover[i] += cover[i - 1];
		}
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (cover[i] >= building[i]) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,1,2,2};
		int[] b = {3,1};
		int[] c = {1,2};
		System.out.println(find(a, b, c));
	}
}
