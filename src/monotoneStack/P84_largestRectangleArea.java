package monotoneStack;

import java.util.Deque;
import java.util.List;

public class P84_largestRectangleArea {
	//时间遍历时间 n
	//空间，栈空间，copy数组空间，n
	public int largestRectangleArea(int[] heights) {	
		int[] newHeights = new int[heights.length + 1];
		for (int i = 0; i < heights.length; i++) {
			newHeights[i] = heights[i];
		}
		heights = newHeights;
		
		int ans = 0;
		Deque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
				ans = Math.max(ans, width * height);
			}
			stack.push(i);
		}
		return ans;
	}
}
