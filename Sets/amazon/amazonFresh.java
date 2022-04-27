package z;

//https://www.1point3acres.com/bbs/thread-883696-1-1.html
//https://leetcode.com/discuss/interview-question/1906290/Amazon-or-OA

public class amazonFresh {
	public static int find(int[] nums) {
		int ans = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			int nans = 0;
			int num = nums[i], j = i - 1;
			while (num != 0 && j >= 0) {
				nans += num;
				if (num > nums[j]) {
					num = nums[j];
				} else {
					num = num - 1;
				}
				j--;
			}
			ans = Math.max(nans, ans);
		}
		return ans; 
	}
	
	public static void main(String[] args) {
		int[] nums = {7,4,5,6,2,5};
		System.out.println(find(nums));
	}
}
