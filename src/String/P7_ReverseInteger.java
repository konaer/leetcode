package String;

public class P7_ReverseInteger {
	//时间n， n是位数。n = log(x)
	//空间l
	public int reverse(int x) {
		int ans = 0;
		while (x != 0) {
			int digit = x % 10;
			if (ans > Integer.MAX_VALUE / 10 || ans < Integer.MIN_VALUE / 10) {
				return 0;
			}	
			ans = 10 * ans + digit;
			x /= 10;
		}
		return ans;
    }
}
