package twoPointer;

public class P80_RemoveDuplicatesfromSortedArray2 {
	//time n
	//space 1
	public int removeDuplicates(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		
		int left = 2, right = 2;
		while (right < nums.length) {
			if (nums[right] != nums[left - 2]) {
				nums[left++] = nums[right];
			}
			right++;
		}
		//注意这里，因为前面有left++，所以最后停的位置超出一位
		//写答案的时候就不是left + 1了
		return left;
	}
}
