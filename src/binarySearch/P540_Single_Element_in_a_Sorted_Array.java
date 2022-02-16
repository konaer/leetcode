package binarySearch;

public class P540_Single_Element_in_a_Sorted_Array {
	//解法一，单纯二分法
//	public int singleNonDuplicate(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//        
//        while (left < right) {
//        	int mid = left + (right - left) / 2;  
//        		if (nums[mid] == nums[mid + 1]) {
//        			if ((right - mid) % 2 == 1) {
//        				right = mid -1;
//        			} else {
//        				left = mid + 2;
//        			}
//        		} else if (nums[mid - 1] == nums[mid]) {
//        			if ((right - mid) % 2 == 0) {
//        				right = mid -2;
//        			} else {
//        				left = mid + 1;
//        			}
//        		} else { 
//        			return nums[mid];
//        		}        	
//        }
//        return nums[left];
//    }
	
	
	
	//解法二，利用偶数项，来二分
	public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
        	int mid = left + (right - left) / 2;
        	int mid2 = mid / 2 * 2;
        	if (nums[mid2] == nums[mid2 + 1]) {
        		left = mid2 + 2;
        	} else {
        		right = mid2;
        	}
        }
        return nums[left];
    }
}
