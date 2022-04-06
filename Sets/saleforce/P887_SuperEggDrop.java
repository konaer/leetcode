import java.util.Map;

public class P887_SuperEggDrop {
	//time knlogn
	//space kn
	Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
	
	public int superEggDrop(int k, int n) {
        if (n == 0) {
        	return 0;
        } else if (k == 1) {
        	return n;
        }
        
        //这个是为了取模让key包含n， k两个数的信息
        int key = n * 1000 + k;
        if (memo.containsKey(key)) {
        	return memo.get(key);
        }
        
        int l = 1, r = n;
        while (l + 1 < r) {
        	int mid = l + (r - l) / 2;
        	int low = superEggDrop(k - 1, mid - 1);
        	int high = superEggDrop(k, n - mid);
        	if (low < high) {
        		l = mid;
        	} else if (low > high) {
        		r = mid;
        	} else {
        		l = r = mid;
        	}
        }
        
        int min = 1 + Math.min(
        		Math.max(superEggDrop(k - 1, l - 1), superEggDrop(k, n - l)),
        		Math.max(superEggDrop(k - 1, h - 1), superEggDrop(k, n - h))
        );
        
        memo.put(key, min);
        return memo.get(key);
    }
}
