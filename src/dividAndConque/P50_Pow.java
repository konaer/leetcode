package dividAndConque;

public class P50_Pow {
	//时间logn，每次递归二分
	//空间logn， 栈空间
	public double myPow(double x, int n) {
		long m = (long) n;
		return m >= 0 ? helper(x, m) : helper (1 / x, -m);
	}
	
	private double helper(double x, long n) {
		double ans = 1.0;
		if (n == 0) {
			return ans;
		}

		double y = helper(x, n / 2);
		if (n % 2 == 0) {
			return y * y;
		} else {
			return y * y * x;
		}
	}
	
	//iteration
	//时间logn
	//空间l
	public double myPow(double x, int n) {
        long m = (long) n;
        double ans = 1.0;
        if (m == 0) {
            return ans;
        }

        if (m < 0) {
            x = 1 / x;
            m *= -1;
        }

        while (m > 0) {
            if ((m & 1) == 1) {
                ans *= x;
            }
            x *= x;
            m /= 2;
        }
        return ans;
    }
}
