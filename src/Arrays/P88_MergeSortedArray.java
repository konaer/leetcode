package Arrays;

public class P88_MergeSortedArray {
	
	
	//时间m + n
	//空间 constant
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i = m - 1, j = n - 1;
		int tail = m + n - 1;
		while (i >= 0 && j >= 0) {
			if (nums1[i] >= nums2[j]) {
				nums1[tail--] = nums1[i--];
			} else {
				nums1[tail--] = nums2[j--];
			}
		}
		
		while (i >= 0) {
			nums1[tail--] = nums1[i--];
		}
		while (j >= 0) {
			nums1[tail--] = nums2[j--];
		}
    }
}
