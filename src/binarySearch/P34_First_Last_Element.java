package binarySearch;

public class P34_First_Last_Element {
	
	public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        int left = findFirst(nums, target);
        int right = findLast(nums, target);
        
        return new int[] {left, right};
    }

    private int findFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private int findLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return nums[r] == target ? l : -1;
    }
}
