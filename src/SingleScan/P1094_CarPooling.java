package SingleScan;

import java.util.Arrays;
import java.util.PriorityQueue;

public class P1094_CarPooling {
	public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1005];
        for (int[] trip : trips) {
        	diff[trip[1]] += trip[0];
        	diff[trip[2]] -= trip[0];
        }
        
        int people = 0;
        for (int num : diff) {
        	people += num;
        	if (people > capacity) {
        		return false;
        	}
        }
        return true;
    }
}
