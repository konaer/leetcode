package SingleScan;

public class P435_NonOverlappingIntervals {
	//nlogn时间排序，n时间遍历。总的是nlogn
	//logn，排序用栈空间
	public int eraseOverlapIntervals(int[][] intervals) {
		int ans = 0;
		Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
		int pre = Integer.MIN_VALUE;
		for (int[] interval : intervals) {
			if (interval[0] < pre) {
				ans++;
			} else {
				pre = interval[1];
			}
		}
		return ans;
    }
}

