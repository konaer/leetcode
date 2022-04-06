package z;

//https://www.1point3acres.com/bbs/thread-857943-1-1.html

import java.util.ArrayDeque;
import java.util.Deque;

public class DiskSpaceAnalysis {
	public static int find(int[] nums, int x) {
		Deque<Integer> dq = new ArrayDeque<>();
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
        	int index = i - x + 1;
        	while (!dq.isEmpty() && i - dq.peekFirst() >= x) {
        		dq.pollFirst();
        	}
        	while (!dq.isEmpty() && nums[i] <= nums[dq.peekLast()]) {
        		dq.pollLast();
        	}
        	dq.offerLast(i);
        	
        	if (index >= 0) {
        		//注意这里是peek，不能poll
        		ans = Math.max(ans, nums[dq.peekFirst()]);
        	}
        }
        return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {8,2,6,4};
		int x = 2;
		System.out.println(find(nums, x));
	}
}
