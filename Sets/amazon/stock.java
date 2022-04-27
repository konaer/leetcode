package z;

public class stock {
	public static int find(int[] nums) {
		int sum = 0;
	    for(int i : nums){
	        sum+=i;
	    }
	    int minNetPrice = Integer.MAX_VALUE, month=-1, n = nums.length;
	    int leftSum=0,rightSum = sum;
	    for(int i=1;i<n;i++){
	       leftSum+=nums[i-1];
	       rightSum-=nums[i-1];
	       int currNet = Math.abs((leftSum/i)-(rightSum/(n-i)));
	       if(minNetPrice>currNet){
	           minNetPrice = currNet;
	           month = i;
	           if(minNetPrice==0) break;
	       }
	    }
	    return month;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,3,2,3};
		System.out.println(find(nums));
	}
}

//Given the stock prices of n months, the net price change for the i-th month 
// is defined as the absolute difference between the average of stock prices for 
//the first i months and for the remaining (n−i) months where 1≤i≤n.
//Note that these averages are rounded down to an integer.
//
//The average of a set of integers here is defined as the sum of integers divided by the number of integers, rounded down to the nearest integer.
//For example, the average of [1, 2, 3, 4] is the floor of (1 + 2 + 3 + 4) / 4 = 2.5 and the floor of 2.5 is 2.
//
//Given an array of stock prices, find the month at which the net price change is minimum.
//If there are several such months, return the earliest month.
