package z;

import java.lang.reflect.Array;
import java.util.Arrays;

public class P1099_TwoSumLessThanK {
	//time nlogn
	//space 1
	public int twoSumLessThanK(int[] nums, int k) {
        int ans = -1;
		int i = 0, j = nums.length - 1; 
        
        Arrays.sort(nums);
        while (i < j) {
        	int sum = nums[i] + nums[j];
        	if (sum >= k) {
        		j--;
        	} else {
        		ans = Math.max(ans, sum);
        		i++;
        	}
        }
        return ans;
    }
}
