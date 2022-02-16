package twoPointer;

public class P26_RemoveDuplicatesFromSortedArray {
//	public int removeDuplicates(int[] nums) {
//        int pointer = 0;
//        if (nums.length == 0) {
//            return 0;
//        }
//
//		for (int i = 1; i < nums.length; i++) {
//			if (nums[pointer] != nums[i]) {
//				pointer++;
//				nums[pointer] = nums[i];
//			}
//		}
//		return pointer + 1;
//    }

	//快慢指针最多各移动n次，一共n+n， 时间复杂度n
	//空间是l
	public int removeDuplicates(int[] nums) {
		int l = 0, r = 1;
        while (r < nums.length) {
            if (nums[r] != nums[l]) {
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
	}
	
}
