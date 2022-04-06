package z;

public class P452_MinimumNumberofArrowstoBurstBalloons {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		
		//注意这里如果直接return a[1] - b[1]的话，有个case过不了
		Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            else if (a[1] < b[1]) return -1;
            else return 0;
        });
        
		int ans = 1;
		int arrow = points[0][1];
		for (int[] p : points) {
			if (p[0] > arrow) {
				arrow = p[1];
				ans++;
			}
		}
		return ans;
    }
}
