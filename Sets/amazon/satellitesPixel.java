package z;

//https://leetcode.com/discuss/interview-question/1753436/Amazon-OA

public class satellitesPixel {
	public static int find(int[][] arr) {
		int[] ones = new int[arr.length];
		int[] zeros = new int[arr.length];
		int[] ones_c = new int[arr[0].length];
	    int[] zeros_c = new int[arr[0].length];
	    for (int i = 0; i< arr.length; i++) {
	        for (int j = 0; j<arr[0].length; j++) {
	            if (arr[i][j] ==1) {
	                ones[i]++;
	                ones_c[j]++;
	            } else {
	                zeros[i]++;
	                zeros_c[j]++;
	            }
	        }
	    }
	    
	    int max = 0;
	    for (int i = 0; i< arr.length; i++) {
	        for (int j = 0; j<arr[0].length; j++) {
	            max =  Math.max(max, ones[i] + ones_c[j] - (zeros[i]+zeros_c[j]));
	        }

	    }
	    return max;
	}
	
	public static void main(String[] args) {
		int[][] arr = {{1,0,1}, {0,0,1}, {1,1,0}};
		System.out.println(find(arr));
	}
}
