package z;

//https://www.1point3acres.com/bbs/thread-854126-1-1.html

public class OfficeDesign {
	public static int find(int[] nums, int k) {
		int l = 0, r = 0, ans = 0, sum = 0;
		while (r < nums.length) {
			sum += nums[r++];
			while (sum > k) {
				sum -= nums[l++];
			}
			ans = Math.max(ans, r - l);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,5,1,1,2,1};
		int k = 15;
		System.out.println(find(nums, k));
	}
}
