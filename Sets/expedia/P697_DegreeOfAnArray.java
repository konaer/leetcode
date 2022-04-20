package z;

public class P697_DegreeOfAnArray {
	//time n
	//space n
	public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            maxCount = Math.max(maxCount, map.get(nums[i]));
            if (!left.containsKey(nums[i])) {
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
        }
        
        int ans = nums.length;
        for (int num : map.keySet()) {
            if (map.get(num) == maxCount) {
                ans = Math.min(ans, right.get(num) - left.get(num) + 1);
            }
        }
        return ans;
    }
}
