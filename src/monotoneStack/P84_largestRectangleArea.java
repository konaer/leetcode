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
		
		Deque<Integer> stack = new ArrayDeque<>();
		int ans = 0;
		
		for (int i = 0; i < heights.length; i++) {
			//注意此处，左边界不一定是其本身，所以不能直接用pop做为左边界
			//另外此处是<还是<= 都可以，等于的情况只是计算在不同的column上，但是都能计算到
			while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
				int height = heights[stack.pop()];
				int width = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
				ans = Math.max(ans, height * width);
			}
			stack.push(i);
		}
		
		return ans;
	}
}
