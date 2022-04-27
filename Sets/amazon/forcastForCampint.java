package z;

import java.util.*;

public class forcastForCampint {
	public static List<Integer> find(int[] day, int k) {
		int n = day.length;
		int[] left = new int[n], right = new int[n];
		for (int i = 1; i < n; i++) {
			if (day[i - 1] >= day[i]) {
				left[i] = left[i - 1] + 1;
			}
		}
		
		for (int i = n - 2; i >= 0; i--) {
			if (day[i + 1] >= day[i]) {
				right[i] = right[i + 1] + 1;
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (left[i] >= k && right[i] >= k) {
				ans.add(i + 1);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] day = {1,0,1,0,1};
		int k = 1;
		System.out.println(find(day, k));
	}
}
