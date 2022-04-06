package z;

public class P53_MaximumSubarray {
	//time n
	//space 1
	public int maxSubArray(int[] nums) {
		//注意ans不能初始化为0，因为有可能第一个是负数。
        int ans = nums[0], sum = 0;
        for (int i = 0; i < nums.length; i++) {
        	sum = Math.max(sum + nums[i], nums[i]);
        	ans = Math.max(ans, sum);
        }
        return ans;
    }
}
