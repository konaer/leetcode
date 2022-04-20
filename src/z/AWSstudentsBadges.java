package z;

// https://www.1point3acres.com/bbs/thread-841736-1-1.html

public class AWSstudentsBadges {
	public static int find(int[] nums) {        
		int length = nums.length;
        int positive = nums[0] > 0 ? 1 : 0;
        int negative = nums[0] < 0 ? 1 : 0;
        int maxLength = positive;
        for (int i = 1; i < length; i++) {
            if (nums[i] > 0) {
                positive++;
                negative = negative > 0 ? negative + 1 : 0;
            } else {
                int newPositive = negative > 0 ? negative + 1 : 0;
                int newNegative = positive + 1;
                positive = newPositive;
                negative = newNegative;
            }
            maxLength = Math.max(maxLength, positive);
        }
        return maxLength;
	}
	
	public static void main(String[] args) {
		int[] nums = { -1,-1,-1,-1,-1, 1};
		System.out.println(find(nums));
	}
}
