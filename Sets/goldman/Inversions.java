package z;

//https://www.1point3acres.com/bbs/thread-857927-1-1.html

public class Inversions {
	public static long find(int[] nums) {
		long ans = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int smaller = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					smaller++;
				}
			}
			
			int bigger = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] < nums[j]) {
					bigger++;
				}
			}
			ans += ((long) smaller * bigger);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {8,4,2,1};
		System.out.println(find(nums));
	}
}
