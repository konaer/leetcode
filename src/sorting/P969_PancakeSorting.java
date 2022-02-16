package sorting;

import java.util.List;

public class P969_PancakeSorting {
	//n^2, 需要n时间找最大，找到后需要n时间翻转
	//空间l
	public List<Integer> pancakeSort(int[] arr) {
		List<Integer> res = new ArrayList<>();
		int largest = arr.length;
		for (int i = 0; i < arr.length; i++) {
			int index = findLargest(arr, largest);
			flip(arr, index);
            //注意这了index是从0开始的，k是从1开始的，要+1
            res.add(index + 1);
			flip(arr, largest - 1);            
			res.add(largest);
			largest--;
		}
		return res;
    }
	
	private int findLargest (int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	private void flip(int[] arr, int index) {
		int i = 0, j = index;
		while (i < j) {
			int temp = arr[i];
			arr[i++] = arr[j];
			arr[j--] = temp;
		}
	}
}
