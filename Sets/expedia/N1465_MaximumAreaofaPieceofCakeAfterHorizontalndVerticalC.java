package z;

public class N1465_MaximumAreaofaPieceofCakeAfterHorizontalndVerticalC {
	
	long mod = 1000000007;
	
	public int maxArea(int h, int w, int[] hs, int[] vs) {
        Arrays.sort(hs);
        Arrays.sort(vs);
        
        long maxh = findMax(hs, h);
        long maxv = findMax(vs, w);
        return (int) (maxh * maxv % mod); 
    }
    
    private long findMax(int[] nums, int k) {
        long ans = Math.max(nums[0], k - nums[nums.length - 1]);
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }
        return ans;
    }
		
}
