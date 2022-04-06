package SingleScan;

public class P628_MaximumProductOfThreeNumbers {
	//时间遍历 n
	//空间 l
	public int maximumProduct(int[] nums) {
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;

		for (int num : nums) {
			if (num <= min1) {
				min2 = min1;
				min1 = num;
			} else if (num > min1 && num <= min2) {
				min2 = num;
			}

			if (num >= max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			} else if (num < max1 && num >= max2) {
				max3 = max2;
				max2 = num;
			} else if (num < max2 && num >= max3) {
				max3 = num;
			}
		}
		
		int candidate1 = max1 * max2 * max3;
		int candidate2 = min1 * min2 * max1;
		return Math.max(candidate1, candidate2);
	}
}
