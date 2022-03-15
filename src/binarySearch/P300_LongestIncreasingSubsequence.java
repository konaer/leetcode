package binarySearch;

import java.util.List;

public class P300_LongestIncreasingSubsequence {
	//time nlogn
	//space n
	public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
        	if (nums[i] > list.get(list.size() - 1)) {
        		list.add(nums[i]);
        	} else {
        		int j = findIndex(list, nums[i]);
        		list.set(j, nums[i]);
        	}
        }
        return list.size();
    }
	
	private int findIndex(List<Integer> list, int target) {
		int l = 0, r = list.size() - 1;
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (list.get(mid) >= target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
}
