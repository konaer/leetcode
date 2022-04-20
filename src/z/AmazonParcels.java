package z;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.1point3acres.com/bbs/thread-882190-1-1.html

public class AmazonParcels {
	public static int find(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			if (num != 0) {
				set.add(num);
			}
		}
		return set.size();
	}
	
	public static void main(String[] args) {
		int[] nums = {7,2,4,3,3};
		System.out.println(find(nums));
	}
}
