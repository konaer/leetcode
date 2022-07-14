package z;

public class P48_RotateImage {
	//time, 两次都是n/2*n, 所以总共是n^2
	//space 1
	public void rotate(int[][] matrix) {
		int n = matrix.length;		
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - i][j];
				matrix[n - 1 - i][j] = temp;
			}
		}		
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
    }
}
