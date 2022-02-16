package hashTable;

import java.util.*;

//空间n，哈希表
//时间n，遍历一遍数组，然后哈希是常数时间
public class P1_TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[] {i, map.get(num)};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
