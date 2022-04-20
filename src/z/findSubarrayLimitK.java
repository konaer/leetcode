package z;

import java.util.*;

public class findSubarrayLimitK {
	public static int find(int[] nums, int limit) {
        Deque<Integer> queMax = new LinkedList<Integer>();
        Deque<Integer> queMin = new LinkedList<Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ans = 0;
        while (right < n) {
            while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                queMax.pollLast();
            }
            while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                queMin.pollLast();
            }
            queMax.offerLast(nums[right]);
            queMin.offerLast(nums[right]);
            while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                if (nums[left] == queMin.peekFirst()) {
                    queMin.pollFirst();
                }
                if (nums[left] == queMax.peekFirst()) {
                    queMax.pollFirst();
                }
                left++;
            }
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,3,6};
		int k = 3;
		System.out.println(find(nums, k));
	}
}

//Find number of possible subarrays from an array , where max and min difference of elements in subarray is less than the given limit.
//
//input : limit ,array
//output : return count of all possible combinations
//leetcode 1438
