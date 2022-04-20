package z;

public class moveZero {
	public static int find(int[] nums) {
		return Math.min(findA(nums, 0), findA(nums, 1));
	}
	
	private static int findA(int[] nums, int m) {
		int ans = 0;
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == m) {
				ans += i - index;
				index++;
			}
		}
		System.out.println(ans);
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,0,1,0,1,0};
		System.out.println(find(nums));
	}
}


//Your task is to sort a binary array and return the minimum number of adjacent swaps needed. The 0's and 1's can be positioned on either end of the array i.e. array can start with 0's or 1's
//I/p: [0,1,0,1] -> 1 (one swap is needed to get [0,0,1,1])
//[1,1,1,0,0] -> 0
//[1,1,1,0,1] -> 1