package binarySearch;

public class P367_Valid_Perfect_Square {
	public boolean isPerfectSquare(int num) {
		int left = 0;
		int right = num;
		
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if ((long)mid * mid == num) {
				return true;
			} else if ((long)mid * mid > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
    }
}
