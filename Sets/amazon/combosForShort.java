package z;

import java.util.*;

//https://www.1point3acres.com/bbs/thread-823007-1-1.html

public class combosForShort {
	public static int[] find(int[] nums, int k) {
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int num : nums) {
			if (num >= 0) {
				list1.add(num);
			} else {
				list2.add(num);
			}
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		Deque<Integer> stack1 = new ArrayDeque<>(list1);
		Deque<Integer> stack2 = new ArrayDeque<>(list2);
		
		List<Integer> ans = new ArrayList<>();
		int item = list1.stream().mapToInt(i -> i).sum();
		ans.add(item);
		while (!stack1.isEmpty() && !stack2.isEmpty() && ans.size() < k) {
			if (stack1.peek() <= (-stack2.peek())) {
				item -= stack1.pop();
				ans.add(item);
			} else {
				item += stack2.pop();
				ans.add(item);
			}
		}
		
		while (!stack1.isEmpty() && ans.size() < k) {
			item -= stack1.pop();
			ans.add(item);
		}
		
		while (!stack2.isEmpty() && ans.size() < k) {
			item += stack2.pop();
			ans.add(item);
		}
			
		return ans.stream().mapToInt(i -> i).toArray();
	}
	
	public static void main(String[] args) {
		int[] nums = {3,5,-2};
		int k = 3;
		int[] a = find(nums, k);
		
		for (int b : a) {
			System.out.println(b);
		}		
	}
}
