package z;

import java.util.*;

public class findAllproductsOfCombinations {
	// 时间n*2^n, 最差情况，一共2^n个解
		// 空间 stack空间n，list空间n，总共是n级别
		static List<Integer> ans = new ArrayList<>();

		public static List<Integer> find(int[] nums) {
			Arrays.sort(nums);
			dfs(nums, 0, 1);
			return ans;
		}

		private static void dfs(int[] nums, int index, int product) {
			for (int i = index; i < nums.length; i++) {
				if (i != index && nums[i] == nums[i - 1]) {
					continue;
				}
				product *= nums[i];
				ans.add(product);
				dfs(nums, i + 1, product);
				product /= nums[i];
			}
		}
		
		public static void main(String[] args) {
			int[] nums = {2,7,11};
			List<Integer> ans = find(nums);
			for (int n : ans) {
				System.out.println(n);
			}
		}
}
