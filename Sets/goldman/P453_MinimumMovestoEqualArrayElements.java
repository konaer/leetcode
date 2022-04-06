package z;

public class P453_MinimumMovestoEqualArrayElements {
	public int minMoves(int[] nums) {
		int minNum = Integer.MAX_VALUE;
		for (int num : nums) {
			minNum = Math.min(minNum, num);
		}
		
		int ans = 0;
		for (int num : nums) {
			ans += num - minNum;
		}
		return ans;
    }
}
