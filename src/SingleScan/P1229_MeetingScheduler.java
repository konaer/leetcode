package SingleScan;

public class P1229_MeetingScheduler {
	//时间排序时间nlogn
	//空间 排序空间logn
	public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
		
		int i = 0, j = 0;
        while (i < slots1.length && j < slots2.length) {
        	int start = Math.max(slots1[i][0], slots2[j][0]);
        	int end = Math.min(slots1[i][1], slots2[j][1]);
        	if (end - start >= duration) {
        		return List.of(start, start + duration);
        	} else {
        		if (slots1[i][1] < slots2[j][1]) {
            		i++;
            	} else {
            		j++;
            	}
        	}
        }
        return new ArrayList<>();
    }
}
