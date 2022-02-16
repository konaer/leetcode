package SlidingWindow;

public class P1248_CountNumberofNiceSubarrays {
	//时间n
	//空间l
	public int numberOfSubarrays(int[] nums, int k) {
		return findMostK(nums, k) - findMostK(nums, k - 1);
    }
	
	private int findMostK(int[] nums, int k) {
		int l = 0, r = 0, ans = 0;
		while (r < nums.length) {
			int right = nums[r++];
			if (right % 2 == 1) {
				k--;
			}
			while (k < 0) {
				int left = nums[l++];
				if (left % 2 == 1) {
					k++;
				}
			}
			ans += r - l;
		}
		return ans;
	}
}
