package twoPointer;

public class L31_PartitionArray {
	public int partitionArray(int[] nums, int k) {
        // write your code here
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
        int l = 0, r = nums.length - 1;
        while (l < r) {
        	while (l < r && nums[l] < k) {
        		l++;
        	}
        	while (l <r && nums[r] >= k) {
        		r--;
        	}
        	if (l < r) {
        		int temp = nums[l];
        		nums[l] = nums[r];
        		nums[r] = temp;
        		l++;
        		r--;
        	}
        }
        return nums[l] < k ? l + 1 : l;
    }
}
