package SingleScan;

import java.util.Arrays;

public class P1288_RemoveCoveredIntervals {
	
	//排序时间 nlogn, 遍历时间n，可忽略
	//排序 栈空间 logn
	public int removeCoveredIntervals(int[][] intervals) {
		
		Arrays.sort(intervals, (s1, s2) -> {
			return s1[0] == s2[0] ? s2[1] - s1[1] : s1[0] - s2[0];
		});
		
		int count = 0;
		int end, preEnd = 0;
		for (int[] interval : intervals) {
			end = interval[1];
			
			if (end > preEnd) {
				count++;
				preEnd = end;
			}
		}
		return count;
    }
}
