package z;

// https://www.1point3acres.com/bbs/thread-867183-1-1.html
// https://www.geeksforgeeks.org/maximum-difference-between-two-elements/

public class SimpleMaxDifferent {
	public static int find (int[] nums) {
		int minNum = nums[0];
		int ans = -1;
		for (int num : nums) {
			if (num > minNum) {
				ans = Math.max(ans, num - minNum);
			} else {
				minNum = num;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,10,2,4,8,1};
		System.out.println(find(nums));
	}
}
