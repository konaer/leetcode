package z;

public class P259_3SumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		//time n^2
		//space l
		int ans = 0;
		
		if (nums.length < 3) {
			return ans;
		}
		
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					//注意这个地方
					ans += k - j;
					j++;
				} else {
					k--;
				}
			}
		}
		return ans;
    }
}
