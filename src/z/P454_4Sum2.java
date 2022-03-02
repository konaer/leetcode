package z;

import java.util.Map;

public class P454_4Sum2 {
	//time n^2
	//space n^2
	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a : nums1) {
        	for (int b : nums2) {
        		map.put(a + b, map.getOrDefault(a + b, 0) + 1);
        	}
        }
        
        for (int c : nums3) {
        	for (int d : nums4) {
        		ans += map.getOrDefault(-(c + d), 0);
        	}
        }
        return ans;
    }
}
