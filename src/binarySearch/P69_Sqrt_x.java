package binarySearch;

public class P69_Sqrt_x {
	
	public int mySqrt(int x) {
		int left = 0;
        int right = x;
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;	
    }
	
}

