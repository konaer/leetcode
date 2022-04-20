package z;

import java.util.HashSet;
import java.util.Set;

public class MinimumCostShipment {
	public static long find(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int ans = 0, i = 1;
		while (k - nums.length > 0) {
			if (!set.contains(i)) {
				ans += i;
				k--;
			}
			i++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,6,10,11};
		int k = 9;
		System.out.println(find(nums, k));
	}
}






//Millions of packages are regularly shipped .
//there ae number of parcels that need to be shipped. compute the minimum possible sum
//of transportation cost incurred in the shippment of additional parcels in the
//following scenario.
//
//1- a fully loaded truck carries K parcels to be fully loaded.
//2- it is most efficient for the truck to be fully loaded.
//3- there are number of parcels already on the truck as listed in parcels[]
//4- there are parcels with unique id that ranges fro 1 to infinity
//5- the parcel id is also the cost to ship that parcel.
//
//Given the parcel ID which are already added in the shippment, find the
//minimum possible cost of shipping the items added to complete the load.
//
//Example:
//
//Parcels = [2,3,6,10,11]
//K = 9
//
//Parcel ids ranges (1 --> inf.).
//after reviewing the current manifest,
//the remaining parcesl to choose from are [1,4,5,7,8,9,12,13,....]
//There are 5 parcels already on the truck, and it can carry K = 9 parcels when fully loaded.
//choose 4 more packages to include [1,4,5,7]
//Their shipping cost is 1 + 4 +5 +7 = 17 which is minimal
//Return 17.
//
//getminimumCost has the following:
//int parcels [n]: the parcels already in shipment
//int K: the trucks capacity
//
//Returns
//Long_int: the minimum additional transportation cost incured
