package z;

public class P162_Find_Peak_Element {
	
	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if (nums[left] < nums[right]) {
			return right;
		} else {
			return left;
		}
    }
}
