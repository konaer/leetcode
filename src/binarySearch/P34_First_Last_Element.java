package binarySearch;

public class P34_First_Last_Element {
	
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return new int[] {-1, -1};
		}
		
		int firstPosition = findFirstPosition(nums, target);
		int lastPosition = findLastPosition(nums, target);
		return new int [] {firstPosition, lastPosition};		
	}
	
	
	private int findLastPosition(int[] nums, int target) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else if (nums[mid] == target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if (nums[right] == target) {
			return right;
		} else if (nums[left] == target) {
			return left;
		} else {
			return -1;
		}	
	}
	
	
	private int findFirstPosition(int[] nums, int target) {
		
		int left = 0;
		int right = nums.length - 1;
		
		while (left+1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid +1;
			} else if (nums[mid] == target) {
				right = mid;
			} else {
				right = mid -1;
			}
		}
		
		if (nums[left] == target) {
			return left;
		} else if (nums[right] == target) {
			return right;
		} else {
			return -1;
		}
	}
}
