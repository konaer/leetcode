package sorting;

public class P912_SortArray {
	//快排
	//期望是 nlogn，最差n
	//空间介于logn和n之间
	public int[] sortArray(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
		return nums;
    }
	
	private void quickSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int index = parition(nums, left, right);
		quickSort(nums, left, index - 1);
		quickSort(nums, index + 1, right);
	}
	
	private int parition(int[] nums, int left, int right) {
		int pivot = nums[right];
		int wall = left;
		for (int i = left; i < right; i++) {
			if (nums[i] < pivot) {
				swap(nums, i, wall++);
			}
		}
		swap(nums, right, wall);
		return wall;
	}
	
	private void swap(int[] nums, int l, int r) {
		int temp = nums[l];
		nums[l] = nums[r];
		nums[r] = temp;
	}
	
	
	
	//Merge sort
	//时间nlogn
	//额外空间需要 n的额外数组， logn的栈空间，合起来取大的， n空间
	public int[] sortArray(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}
	
	private int[] mergeSort(int[] nums, int l, int r) {
		if (l == r) {
			return new int[] {nums[l]};
		}
		
		int mid = l + (r - l) / 2;
		int[] leftRes = mergeSort(nums, l, mid);
		int[] rightRes = mergeSort(nums, mid + 1, r);
		return merge(leftRes, rightRes);
	}
	
	private int[] merge(int[] left, int[] right) {
		int[] res = new int[left.length + right.length];
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				res[k++] = left[i++];
			} else {
				res[k++] = right[j++];
			}
		}
		
		while (i < left.length) {
			res[k++] = left[i++];
		}
		while (j < right.length) {
			res[k++] = right[j++];
		}
		return res;
	}
	
	//heap Sort
	//初始建堆o(n),建成后要进行n-1次调整，每次调整logn所以是nlogn
	//n + nlogn, 取nlogn
	
	//o（logn） 空间,栈空间
	public int[] sortArray(int[] nums) {
		heapSort(nums);
		return nums;
	}
	
	private void heapSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		
		buildMaxHeap(nums);
		//注意这个地方到i = 1就行了，最后一个不用换了
		for (int i = nums.length - 1; i >=1; i--) {
			swap(nums, 0, i);
			heapify(nums, i, 0);
		}
	}
	
	private void buildMaxHeap(int[] nums) {
		int half = nums.length / 2;
		for (int i = half; i >= 0; i--) {
			heapify(nums, nums.length, i);
		}
	}
	
	private void heapify(int[] nums, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		
		//注意下面都要用largest，不是index，错过一次
		int largest = index;
		if (left < heapSize && nums[largest] < nums[left]) {
			largest = left;
		}
		
		if (right < heapSize && nums[largest] < nums[right]) {
			largest = right;
		}
		
		if (index != largest) {
			swap(nums, index, largest);
			heapify(nums, heapSize, largest);
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
}
