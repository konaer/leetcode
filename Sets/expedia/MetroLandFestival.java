package z;

import java.util.*;
import java.util.List;

//https://leetcode.com/discuss/interview-question/1570545/expedia-oa-metro-land-festival

public class MetroLandFestival {
	public static int find(int[] x, int[] y, int[] people) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			while (people[i] > 0) {
				rows.add(x[i]);
				cols.add(y[i]);
				people[i]--;
			}
		}
		
		Collections.sort(rows);
		Collections.sort(cols);
		
		int mx = rows.get(rows.size() / 2);
		int my = cols.get(cols.size() / 2);
		return findTotal(rows, mx) + findTotal(cols, my);
		
	}
	
	private static int findTotal(List<Integer> rows, int mx) {
		int ans = 0;
		for (int row : rows) {
			ans += Math.abs(row - mx);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] x = {1,3};
		int[] y = {1,3};
		int[] people = {1,2};
		
		System.out.println(find(x, y, people));
	}
}
