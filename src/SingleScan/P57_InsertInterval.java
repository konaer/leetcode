package SingleScan;

import java.util.*;

public class P57_InsertInterval {

	// 时间复杂度就是遍历的时间，o(n)
	// 除了储存答案的，额外只需 0（1） 空间
	public int[][] insert(int[][] intervals, int[] newInterval) {
		List<int[]> ans = new ArrayList<>();
		int i = 0;
		//千万别忘了加 第一个条件！！！！
		while (i < intervals.length && intervals[i][1] < newInterval[0]) {
			ans.add(intervals[i++]);
		}

		while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
			newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
			newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
			i++;
		}
		ans.add(newInterval);

		while (i < intervals.length) {
			ans.add(intervals[i++]);
		}
		return ans.toArray(new int[ans.size()][]);
	}
}
