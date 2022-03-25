import java.util.Deque;

public class P735_AsteroidCollision {
	//time n
	//space n
	public int[] asteroidCollision(int[] asts) {
		Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < asts.length) {
            if (stack.isEmpty() || stack.peek() < 0 || asts[i] > 0) {
                stack.push(asts[i++]);
            } else {
                if (stack.peek() < -asts[i]) {
                    stack.pop();
                } else if (stack.peek() == -asts[i]) {
                    stack.pop();
                    i++;
                } else {
                    i++;
                }
            }
        }
        int[] ans = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            ans[j] = stack.pop();
        }
        return ans;
    }
}
