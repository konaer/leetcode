package MonotonicQueue;

import java.util.Deque;

public class P239_SlidingWindowMaximum {
	//时间n，每个元素出入deque一次
	//空间， deque空间。 k
	public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
        	int index = i - k + 1;
        	while (!deque.isEmpty() && i - deque.peekFirst() >= k) {
        		deque.pollFirst();
        	}
        	while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
        		deque.pollLast();
        	}
        	deque.offerLast(i);
        	
        	if (index >= 0) {
        		//注意这里是peek，不能poll
        		ans[index] = nums[deque.peekFirst()];
        	}
        }
        return ans;
    }
}
