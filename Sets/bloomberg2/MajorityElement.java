package z;

public class P169_MajorityElement {
	//nlogn
	public int majorityElement(int[] nums) {
        int n = nums.length;
		Arrays.sort(nums);
        int mElement = nums[nums.length / 2];
        
        int count = 0;
        for (int num : nums) {
        	if (num == mElement) {
        		count++;
        	}
        }
        return count > n / 2 ? mElement : -1;
    }
	
	//Moore法，求mode众数
//	public int majorityElement(int[] nums) {
//        int ans = nums[0];
//        int count = 0;
//        for (int num : nums) {
//            if (count == 0) {
//                ans = num;
//            }
//            
//            if (ans == num) {
//                count++;
//            } else {
//                count--;
//            }       
//        }
//        return ans;
//    }
}
