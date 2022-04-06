package z;

public class P179_LargestNumber {
	public String largestNumber(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
        }
        
        Arrays.sort(arr, (a, b) -> {
        	int na = 10, nb = 10;
        	while (na <= a) {
        		na *= 10;
        	}
        	
        	while (nb <= b) {
        		nb *= 10;
        	}
        	
        	return (na * b + a) - (nb * a + b);
        });
        
        if (arr[0] == 0) {
        	return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (Integer num : arr) {
        	sb.append(num);
        }
        return sb.toString();
    }
}
