package binarySearch;

public class P33_Search_in_Rotated_Sorted_Array {
	
	public int search(int[] nums, int target) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[left] <= nums[mid]) {
				if (nums[left] <= target && target <= nums[mid]) {
					right = mid;
				} else {
					left = mid;
				}
			} else {
				if (nums[mid] <= target && target <= nums[right]) {
					left = mid;
				} else {
					right = mid;
				}
			}
		}
		
		if (nums[left] == target) {
			return left;
		} else if (nums[right] ==  target) {
			return right;
		} else {
			return -1;
		}
    }
}
