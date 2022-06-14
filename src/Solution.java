
import java.util.*;

class Solution {
    
	public static List<Integer> find(int[] nums, int index) {
		Set<Integer> set = new HashSet<>();
		int[] arr = new int[nums.length];
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (i == index || set.contains(nums[i])) {
				nums[i] = -2;
				set.add(i);
				count++;
			}
			arr[i] = count;
		}
		

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				continue;
			} else {
				nums[i] -= arr[nums[i]];
			}
		}
		
		List<Integer> ans = new ArrayList<>();
		for (int num : nums) {
			if (num != -2) {
				ans.add(num);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 0, 2, 3, 1};
		int index = 3;
		List<Integer> ans = find(nums, index);
		for (int num : ans) {
			System.out.print(num + " ");
		}
	}
}


