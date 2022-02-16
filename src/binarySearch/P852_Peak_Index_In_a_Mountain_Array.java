package binarySearch;

public class P852_Peak_Index_In_a_Mountain_Array {
	public int peakIndexInMountainArray(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < arr[mid + 1]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (arr[left] <= arr[right]) {
			return right;
		} else {
			return left;
		}
    }
}
