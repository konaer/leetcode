package twoPointer;

public class L604_WindowSum {
	public int[] winSum(int[] nums, int k) {
        if (nums == null || k > nums.length || k == 0) {
        	return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
        	result[0] += nums[i];
        }
        for (int i = 1; i < result.length; i++) {
        	result[i] = result[i - 1] - nums[i - 1] + nums[i + k - 1];
        }
        return result;
    }
}
