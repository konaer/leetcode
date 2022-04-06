package z;

public class P191_NumberOf1Bits {
	//time logn
	//space l
	public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
        	n &= (n - 1);
        	ans++;
        }
        return ans;
    }
	
	
	//第二种解法
	public int hammingWeight(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                ans++;
            }
        }
        return ans;
    }
}
