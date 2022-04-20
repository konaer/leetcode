package z;

public class N1492_ThekthFactorofN {
	//time n
	//space 1
	public int kthFactor(int n, int k) {
        for (int i = 1; i <=n; i++) {
            if (n % i == 0) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
        }
        return -1;
    }
	
	
	
	//优化方法 time sqrt(n)
	public int kthFactor(int n, int k) {
		int i = 1;
		for (; i * i < n; i++) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }
		
		if (i * i != n) {
			i--;
		}
		
		for (; i >= 1; i--) {
			if (n % i == 0 && --k == 0) {
                return n / i;
            } 
		}
		
		return -1;
	}
}
