package twoPointer;

public class P16_3SumClosest {
	public int threeSumClosest(int[] nums, int target) {
		int n = nums.length;
		int ans = nums[0] + nums[1] + nums[2];
		Arrays.sort(nums);
		
		for (int i = 0; i < n - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int l = i + 1, r = n - 1;
			while (l < r) {
				int sum = nums[i] + nums[l] + nums[r];
				if (sum == target) {
					return target;
				} 
				
				if (Math.abs(sum - target) < Math.abs(ans - target)) {
					ans = sum;
				}

				if (sum > target) {
					r--;
				} else {
					l++;
				}
								
			}			
		}
		return ans;
    }
}
