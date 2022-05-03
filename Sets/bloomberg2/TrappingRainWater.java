package z;

import java.util.Deque;

public class P42_TrappingRainWater {
	//时间n
	//空间 stack空间n
	public int trap(int[] height) {
		Deque<Integer> stack = new LinkedList<>();
		int ans = 0;
		for (int i = 0; i < height.length; i++) {
			while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
				int bottom = stack.pop();
				if (stack.isEmpty()) {
					break;
				}
				int realHeight = Math.min(height[stack.peek()], height[i]) - height[bottom];
				ans += realHeight * (i - stack.peek() - 1);
			}
			stack.push(i);
		}
		return ans;
	}
}
