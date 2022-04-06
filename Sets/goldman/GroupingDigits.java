package z;

//https://www.1point3acres.com/bbs/thread-800317-1-1.html

public class GroupingDigits {
	public static int find(int[] nums) {
		int ans1 = 0, pointer1 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				ans1 += Math.abs(i - pointer1);
				pointer1++;
			}
		}
		
		int ans2 = 0, pointer2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				ans2 += Math.abs(i - pointer2);
				pointer2++;
			}
		}
		return Math.min(ans1, ans2);
    }
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,1};
		System.out.println(find(nums));
	}
}
