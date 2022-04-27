package z;

public class PascalTriangleDecryption {
	public static String find(int[] nums) {
		
		int index = nums.length;
		while (index > 2) {
			for (int i = 0; i < nums.length - 1; i++) {
				nums[i] = nums[i] + nums[i + 1];
				while (nums[i] >= 10) {
					nums[i] %= 10;
				}
			}
			index--;
		}
		return nums[0] + "" + nums[1];
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(find(nums));
	}
}
