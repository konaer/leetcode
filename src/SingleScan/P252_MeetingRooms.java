package SingleScan;

import java.util.Arrays;

public class P252_MeetingRooms {
	public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (s1, s2) -> s1[0] - s2[0]);
		for (int i = 0; i < intervals.length - 1; i++) {
			if (intervals[i][1] > intervals[i + 1][0]) {
				return false;
			}
		}
		return true;
    }
}
