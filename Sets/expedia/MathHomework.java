package z;

//https://leetcode.com/discuss/interview-question/799301/students-have-been-assigned-a-series-of-math-problems

public class MathHomework {
	public static int find(int k, int[] points) {
		int n = points.length;
		if (points[n - 1] - points[0] < k) {
			return n;
		}
		
		int index = 0;
		for (int i = 0; i < points.length; i++) {
			if (points[i] - points[0] >= k) {
				index = i;
				break;
			}
		}
		
//		int left = 0, right = n - 1;
//		while (left < right) {
//			int mid = left + (right - left) / 2;
//			if (points[mid] >= k) {
//				right = mid;
//			} else {
//				left = mid + 1;
//			}
//		}
		return (index + 1) / 2 + 1;
	}
	
	public static void main(String[] args) {
		int[] points = {1,3,4,7};
		System.out.println(find(4, points));
	}
}
