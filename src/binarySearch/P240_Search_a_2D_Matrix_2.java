package binarySearch;

//public class N240_Search_a_2D_Matrix_2 {
//	
//	//时间复杂度 o(nlog m), 另一种方法是搜索算法，时间复杂度m+n
//	
//	public boolean searchMatrix(int[][] matrix, int target) {
//        
//		int n = matrix.length;
//		int m = matrix[0].length;
//		
//		for (int[] nums : matrix) {
//			if (searchRow(nums, target)) {
//				return true;
//			}
//		}
//		return false;
//    }
//	
//	private boolean searchRow(int[] nums, int target) {
//		int left = 0;
//		int right = nums.length - 1;
//		while (left < right) {
//			int mid = left + (right - left) / 2;
//			if (nums[mid] >= target) {
//				right = mid;
//			} else {
//				left = mid + 1;
//			}
//		}
//		return nums[left] == target;
//	}
//}






public class P240_Search_a_2D_Matrix_2 {
	
	//搜索算法，时间复杂度m+n
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix[0].length;
		int n = matrix.length;
		
		int i = 0;
		int j = n - 1;
		
		while (i < m && j >= 0) {
			int element = matrix[j][i];
			if (element == target) {
				return true;
			} else if (element < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}		
}
