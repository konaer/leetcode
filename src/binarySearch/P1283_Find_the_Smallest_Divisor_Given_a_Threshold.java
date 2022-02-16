package binarySearch;

public class P1283_Find_the_Smallest_Divisor_Given_a_Threshold {
	
	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = 0;
		int divisor = -1;
		
		for (int num : nums) {
			right = Math.max(num, right);
		}
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int sum = 0;
			for (int num : nums) {
				sum += (num - 1) / mid + 1;
			}
			if (sum <= threshold) {
				divisor = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return divisor;
	}
}
