package SingleScan;

import java.util.*;

public class P56_MergeIntervals {
	// 排序时间nlogn，遍历需要n时间，忽略了。
	// 储存答案需要n,不计算在内, 排序需要logn空间
	public int[][] merge(int[][] intervals) {
        int[] last, current;
        Arrays.sort(intervals, (s1, s2) -> s1[0] - s2[0]);
        
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            last = res.get(res.size() - 1);
            current = intervals[i];
            if (last[1] < current[0]) {
                res.add(current);
            } else {
                last[1] = Math.max(last[1], current[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
