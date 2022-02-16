package twoPointer;

public class P75_SortColors {
	public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        //这个地方一定注意，i到了right这里就不走了，要不就走过了，本来换对了，又换回来了。
        //注意是小于等于right，因为right每次都往前多走一个位置，这个位置的数字并没有被判断
        for (int i = 0; i <= right; i++) {
        	if (nums[i] == 0) {
        		swap(nums, i, left);
        		left++;
        	} else if (nums[i] == 2) {
        		swap(nums, i, right);
        		right--;
        		//注意这个地方，因为从后面swap过来的数字不一定是个什么玩意，所以应该再判断一次第i个数
        		i--;
        	}
        }
    }
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
