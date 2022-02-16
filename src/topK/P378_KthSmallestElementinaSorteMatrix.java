package topK;

import java.util.Queue;

public class P378_KthSmallestElementinaSorteMatrix {
	//答案二分
	//时间 二分查找 log(r - l), 每次判断的时间是n，所以总的是nlog(r-l)
	//空间l
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int left = matrix[0][0];
		int right = matrix[n - 1][n - 1];
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (check(matrix, n, mid, k)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
    }
	
	private boolean check(int[][] matrix, int n, int mid, int k) {
		int count = 0;
		int i = n - 1, j = 0;
		while (i >= 0 && j < n) {
			if (matrix[i][j] <= mid) {
				//这里不只是加了这一排上的点，是把这个点往上的整个列都给加进来了。
				count += i + 1;
				j++;
			} else {
				i--;
			}
		}
		return count >= k;
	}
}
