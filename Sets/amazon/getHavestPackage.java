package z;

import java.util.ArrayDeque;
import java.util.Deque;

public class getHavestPackage {
	public static int find(int[] nums) {
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = nums.length - 1; i >=0; i--) {
			while (!stack.isEmpty() && stack.peek() > nums[i]) {
				nums[i] += stack.pop();
			}
			stack.push(nums[i]);
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		int[] nums = {2,9,10,3,7};
		System.out.println(find(nums));
	}
}
