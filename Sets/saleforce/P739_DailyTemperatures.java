package monotoneStack;

import java.util.Deque;

public class P739_DailyTemperatures {
	//遍历时间，n
	//单调栈空间 n
	public int[] dailyTemperatures(int[] temps) {
		int n = temps.length;
		int[] res = new int[n];
		Deque<Integer> stack = new LinkedList<>();
		for (int i = n - 1; i >=0; i--) {
			while(!stack.isEmpty() && temps[i] >= temps[stack.peek()]) {
				stack.pop();
			}
			res[i] = (stack.isEmpty() ? 0 : stack.peek() - i);
			stack.push(i);
		}
		return res;
    }
}
