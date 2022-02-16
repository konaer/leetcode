package monotoneStack;

import java.util.Deque;
import java.util.Map;

public class P496_NextGreaterElement {
	//时间 n1 + n2
	//空间 map和stack空间， n2
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);   
        }
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i <nums1.length; i++) {
        	ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}
