package twoPointer;

public class P283_MoveZeros {
	//swap的解法，这种跑起来慢，因为每次都要swap
//	public void moveZeroes(int[] nums) {
//		int i = 0;
//		int j = 0;
//		
//		while (j <nums.length) {
//			if (nums[j] != 0) {
//				swap(nums, i, j);
//				System.out.println(nums[i]);
//				i++;
//			}
//			j++;
//		}
//    }
//	
//	public void swap(int[] nums, int i, int j) {
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//	}
	
	public void moveZeroes(int[] nums) {
		int pointer = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[pointer++] = num;
			}
		}
		while (pointer <nums.length) {
			nums[pointer++] = 0;
		}
	}
	
	
}
