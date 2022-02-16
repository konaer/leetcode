package twoPointer;

public class L610_TwoSumDifferenceEqualsToTarget {
	public int[] twoSum7(int[] nums, int target) {
        // write your code here
		if (nums.length < 2) {
			return new int[0];
		}
		
		target = Math.abs(target);
		
		int p = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			//注意这里用这种方法，使每次p指针不用往回倒了。保证了时间复杂度。
			p = Math.max(p, i + 1);
			while (p < nums.length && nums[p] - nums[i] < target) {
				p++;
			}
			if (nums[p] - nums[i] == target) {
				return new int[] { nums[i], nums[p] };
			}
		}
		return new int[0];      
    }
}
