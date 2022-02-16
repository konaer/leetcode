package twoPointer;

public class L373_PartitionArrayByOddAndEven {
	public void partitionArray(int[] nums) {
        // write your code here
        int l = 0, r = nums.length - 1;
        for (int i = 0; i < r; i++) {
            if (nums[i] % 2 == 1) {
                swap(nums, i, l++);
            } else {
                swap(nums, i--, r--);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
