package greedy;

public class P55_JumpGame {
	//时间n
	//空间1
	public boolean canJump(int[] nums) {
		int end = 0;
        for (int i = 0; 0 < nums.length; i++) {
            if (end >= i) {
                end = Math.max(end, i + nums[i]);
                if (end >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
