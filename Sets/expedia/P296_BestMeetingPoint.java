package z;

import java.util.Collections;
import java.util.List;

public class P296_BestMeetingPoint {
	//time mnlogmn
	//space mn
	public int minTotalDistance(int[][] grid) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == 1) {
        			row.add(i);
        			col.add(j);
        		}
        	}
        }
        Collections.sort(col);
        
        return findMin(row) + findMin(col);
        
    }
	
	private int findMin(List<Integer> list) {
		int ans = 0;
		int left = 0, right = list.size() - 1;
		while (left < right) {
			ans += list.get(right) - list.get(left);
			right--;
			left++;
		}
		return ans;
	}
}
