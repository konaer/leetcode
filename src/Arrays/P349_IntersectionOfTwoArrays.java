package Arrays;

import java.util.Set;

public class P349_IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		for (int num : nums1) {
			set.add(num);
		}
		
		for (int num : nums2) {
			if (set.contains(num)) {
				set2.add(num);
			}
		}
		
		int[] ans = new int[set2.size()];
		int i = 0;
		for (int num : set2) {
			ans[i++] = num;
		}
		
		return ans;		
    }
}
