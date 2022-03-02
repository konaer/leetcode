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
		
		int index = parition(nums, l, r);
		if (index == nums.length - k) {
			return;
		} else if (index < nums.length - k) {
			helper(nums, index + 1, r, k);
		} else {
			helper(nums, l, index - 1, k);
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
	//时间nlogk, 建堆n， n个删除logk，所以是nlogk
	//总时间 n + nlogk = nlogk
	//空间 heap的空间， 放了n个数
	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
	}
}
