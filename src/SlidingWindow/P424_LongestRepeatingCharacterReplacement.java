package SlidingWindow;

public class P424_LongestRepeatingCharacterReplacement {
	//时间n
	//空间 array空间， 字符种类数
	public int characterReplacement(String s, int k) {
        int[] nums = new int[26];
        int l = 0, r = 0;
        int maxNum = 0;
        while (r < s.length()) {
        	char c = s.charAt(r++);
        	nums[c - 'A']++;
        	maxNum = Math.max(maxNum, nums[c - 'A']);
        	if (r - l > maxNum + k) {
        		//这个地方不好想通，左侧缩进时候不需要更新maxNUM,
        		//注意看这里是if，不是while，也就是 滑动窗口要么不变，要么变大
        		//此时除非出现更大的maxNum，否则此时的滑动窗口就是最大。
        		char leftChar = s.charAt(l++);
        		nums[leftChar - 'A']--;
        	}
        }
        return r - l;
    }
}
