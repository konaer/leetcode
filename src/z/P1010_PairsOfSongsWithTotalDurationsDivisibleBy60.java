package z;

public class P1010_PairsOfSongsWithTotalDurationsDivisibleBy60 {
	//time n
	//space l
	public int numPairsDivisibleBy60(int[] time) {
        int[] nums = new int[60];
        int ans = 0;
        for (int t : time) {
            int i = t % 60;
            if (i == 0) {
                ans += nums[0];
            } else {
                ans += nums[60 - i];
            }
            nums[i]++;
        }
        return ans;
    }
}
