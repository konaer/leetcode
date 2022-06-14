package z;

public class bigestNumber {
	
	static int ans = 0;
	
	
	public static int find(int[][] m) {
		dfs(m, m.length, 0, 0);
		return ans;
	}
	
	private static void dfs(int[][] m, int x, int y, int sum) {
		if (x == 0 && y == m[0].length - 1) {
			sum += m[x][y];
			ans = Math.max(ans, sum);
			return;
		}
		
		if (x >= 0 && y < m[0].length) {
			sum += m[x][y];
			dfs(m, x - 1, y, sum);
			dfs(m, x, y + 1, sum);
		}
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,3,6,7}, {3,2,5,3}, {1,3,1,1}};
		System.out.println(find(m));
	}
}
