

package binarySearch;

public class P74_Search_a_2D_Matrix {
		
	public boolean searchMatrix(int[][] matrix, int target) {
		
		int n = matrix.length;
		int m = matrix[0].length;
		
		int first = 0;
		int last = m * n - 1;
		
		while (first < last) {
			int mid = first + (last - first) / 2;
			if (getElement(matrix, mid, m) >= target) {
				last = mid;
			} else {
				first = mid + 1;
			}
		}
		return getElement(matrix, first, m) == target;

	}
	
	private int getElement(int[][] matrix, int mid, int m) {
		
		int i = mid / m;
		int j = mid % m;
		return matrix[i][j];
	}
}
