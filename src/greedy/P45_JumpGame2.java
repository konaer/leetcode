package greedy;

public class P45_JumpGame2 {
	//时间 n
	//空间l
	public int jump(int[] nums) {
		
		int maxPosition = 0, end = 0, steps = 0;
		//注意这里，最后一格不要算，因为从前面跳到这里就结束了
		//如果算这一格，会多算一次
		for (int i = 0; i < nums.length - 1; i++) {
			maxPosition = Math.max(maxPosition, i + nums[i]);
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}
		return steps;
    }
}
