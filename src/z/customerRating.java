package z;

// https://www.1point3acres.com/bbs/thread-882899-1-1.html

public class customerRating {
	public static int find(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return 1;
		}
		
		int ans = 0, index = 0;
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1]) {
				int k = i - index;
				ans += k * (1 + k) / 2;
				index = i;
			}
		}
		int t = n - index;
		ans += t * (1 + t) / 2;
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {4};
		System.out.println(find(nums));
	}
}
