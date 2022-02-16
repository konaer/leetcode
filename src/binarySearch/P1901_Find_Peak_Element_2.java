package binarySearch;

public class P1901_Find_Peak_Element_2 {
	
	public int[] findPeakGrid(int[][] mat) {
        int top = 0;
        int bottom = mat.length -1;

        while (top < bottom) {
            int mid = top + (bottom - top) / 2;

            int m1 = findMax(mat, mid);
            int m2 = findMax(mat, (mid + 1));

            int max1 = mat[mid][m1];
            int max2 = mat[mid + 1][m2];

            if (max1 > max2) {
                bottom = mid;
            } else {
                top = mid + 1;
            }
        }
        return new int[] {top, findMax(mat, top)};
    }

    private int findMax(int[][] mat, int row){
        int count = 0;
        for (int i = 0; i < mat[row].length; i++) {
            if (mat[row][count] < mat[row][i]) {
                count = i;
            }
        }
        return count;
    }
}
