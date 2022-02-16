package topK;

import java.util.Queue;

public class P215_KthLargestElementInArray {
	//平均时间 o（n） 最坏的情况 n^2
	//空间期望是 log（n）， 最坏是n
	public int findKthLargest(int[] nums, int k) {
		helper(nums, 0, nums.length - 1, k);
		return nums[nums.length - k];
    }
	
	private void helper(int[] nums, int l, int r, int k) {
		if (l >= r) {
			return;
		}
		
		int num = parition(nums, l, r);
		if (num == nums.length - k) {
			return;
		} else if (num <nums.length - k) {
			helper(nums, num + 1, r, k);
		} else {
			helper(nums, l, num - 1, k);
		}
	}
	
	private int parition(int[] nums, int l, int r) {
		int pivot = nums[r];
		int wall = l;
		for (int i = l; i < r; i++) {
			if (nums[i] <= pivot) {
				swap(nums, i, wall++);
			}
		}
		swap(nums, r, wall);
		return wall;
	}
	
	//如果用random的取pivot方法
//	private int randomParition(int[] nums, int l, int r) {
//        int index = (int) Math.random() * (r - l + 1) + l;
//        swap(nums, index, r);
//        return parition(nums, l, r);
//    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	
	
	//使用堆
	//时间nlogn, 建堆n， k个删除logn，所以是klogn
	//总时间 n + klogn = nlogn
	//空间 heap的空间， 放了n个数
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
		for (int num : nums) {
			heap.offer(num);
		}
		
		int ans = 0;
		while (k > 0) {
			ans = heap.poll();
			k--;
		}
		return ans;
	}
}
