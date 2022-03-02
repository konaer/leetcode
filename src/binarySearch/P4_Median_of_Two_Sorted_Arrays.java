package binarySearch;

public class P4_Median_of_Two_Sorted_Arrays {
	
	//时间 log(min(m, n))
	//空间 l
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int median1 = 0, median2 = 0;
		int left = 0, right = m;
		
		while (left <= right) {			
			int i = left + (right - left) / 2;
			int j = (m + n + 1) / 2 - i; 
			
			int nums1_iminus = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
			int nums1_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
			int nums2_jminus = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
			int nums2_j = (j == n ? Integer.MAX_VALUE : nums2[j]);
			
			if (nums1_iminus <= nums2_j) {
				median1 = Math.max(nums1_iminus, nums2_jminus);
				median2 = Math.min(nums1_i, nums2_j);
				left = i + 1;
			} else {
				right = i - 1;
			}			
		}
				
		if ((m + n) % 2 == 0) {
			return (double) ((median1 + median2) / 2.0);			
		} else {
			return (double) median1;
		}
    }
}
