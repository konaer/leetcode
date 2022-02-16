package topK;

public class P263_UglyNumber {
	
	//时间logn，每次相除，n至少少一半
	//空间l
	
	public boolean isUgly(int n) {
		if (n <= 0) {
			return false;
		}
		
		int[] factors = {2,3,5};
		for (int factor : factors) {
			while (n % factor == 0) {
				n /= factor;
			}
		}
		return n == 1;
    }
}
