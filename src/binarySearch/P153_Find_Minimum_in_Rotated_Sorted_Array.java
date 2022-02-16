package binarySearch;

public class P153_Find_Minimum_in_Rotated_Sorted_Array {
	
	public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[nums.length - 1]) {
                right = mid;
            } else {
                left = mid; 
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}
