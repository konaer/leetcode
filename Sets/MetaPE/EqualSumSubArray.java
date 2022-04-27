package z;

import java.util.*;

public class EqualSumSubArray {
	public static void find(int[] nums) {
		int leftSum = 0, rightSum = 0;
		for (int i = 0; i < nums.length; i++) {
			rightSum += nums[i];
		}
		
		for (int i = 0; i < nums.length; i++) {
			leftSum += nums[i];
			rightSum -= nums[i];
			if (leftSum == rightSum) {
				int[] ans1 = Arrays.copyOfRange(nums, 0, i + 1);
				int[] ans2 = Arrays.copyOfRange(nums, i + 1, nums.length);
				System.out.println(Arrays.toString(ans1));
				System.out.println(Arrays.toString(ans2));
				return;
			}
		}
		System.out.println("not find");	
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,1,3};
		find(nums);
	}
}
