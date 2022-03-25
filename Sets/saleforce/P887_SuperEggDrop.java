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
        
        int key = n * 1000 + k;
        if (memo.containsKey(key)) {
        	return memo.get(key);
        }
        
        int l = 1, h = n;
        while (l + 1 < h) {
        	int mid = l + (h - l) / 2;
        	int low = superEggDrop(k - 1, mid - 1);
        	int high = superEggDrop(k, n - mid);
        	if (low < high) {
        		l = mid;
        	} else if (low > high) {
        		h = mid;
        	} else {
        		l = h = mid;
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
