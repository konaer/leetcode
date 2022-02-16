package monotoneStack;

import java.util.Deque;

public class P503_NextGreaterElement2 {
	//时间 n， 遍历两次
	//空间 栈空间， n级别
	public int[] nextGreaterElements(int[] nums) {
		int[] ans = new int[nums.length];
		Deque<Integer> stack = new LinkedList<>();
		int n = nums.length;
		for (int i = 2 * n - 1; i >=0; i--) {
			while (!stack.isEmpty() && nums[i % n] >= stack.peek()) {
				stack.pop();
			}
			ans[i % n] = (stack.isEmpty() ? -1 : stack.peek());
			stack.push(nums[i % n]);
		}
		return ans;
    }
}
