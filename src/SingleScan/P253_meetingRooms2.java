package SingleScan;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P253_meetingRooms2 {
	//排序复杂度 nlogn
	//空间n， 额外建了一个数组
	public int minMeetingRooms(int[][] intervals) {
		List<int[]> list = new ArrayList<>();
		for (int[] interval : intervals) {
			list.add(new int[] {interval[0], 1});
			list.add(new int[] {interval[1], -1});
		}
		Collections.sort(list, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});
		
		int ans = 0, count = 0;
		for (int[] point : list) {
			count += point[1];
			ans = Math.max(ans, count);
		}
		return ans;
    }
	
	//priorityQueue解法
	//时间 排序nlogn， 最差情况，最小堆也是nlogn时间，所以时间是nlogn
	//空间 堆空间最差时间为n
	public int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0) {
			return 0;
		}
		
		Arrays.sort(intervals, (a , b) -> a[0] - b[0]);
		PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> a - b);
		heap.offer(intervals[0][1]);
		//注意这里一定要从i=1开始
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= heap.peek()) {
				heap.poll();
			}
			heap.offer(intervals[i][1]);
		}
		return heap.size();
	}
}
