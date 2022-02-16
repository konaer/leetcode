package binarySearch;

public class P410_Split_Array_Largest_Sum {
	
	public int splitArray(int[] nums, int m) {
		int min = 0;
        int max = 0;

        for (int num : nums) {
            min = Math.max(min, num);
            max += num;
        }

        while (min < max) {
            int mid = min + (max - min) / 2;
            if (checkMid(nums, m, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    private boolean checkMid(int[] nums, int m, int mid) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] <= mid) {
                sum += nums[i];
            } else {
                sum = nums[i];
                count++;
            }
        }
        return count <= m;
	}
}
