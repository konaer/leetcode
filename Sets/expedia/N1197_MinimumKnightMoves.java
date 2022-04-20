package z;

import java.util.Map;

public class N1197_MinimumKnightMoves {
	
	private Map<Long, Integer> map = new HashMap<>();
	
	public int minKnightMoves(int x, int y) {
		return dfs(Math.abs(x), Math.abs(y));
    }
	
	private int dfs(int x, int y) {
		long key = hash(x, y);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		
		if (x + y == 0) {
			map.put(key, 0);
			return 0;
		}
		
		if (x + y == 2) {
			map.put(key, 2);
			return 2;
		}
		
		map.put(key, Math.min(dfs(Math.abs(x - 1), Math.abs(y - 2)), dfs(Math.abs(x - 2), Math.abs(y - 1))) + 1);
		return map.get(key);
	}
	
	private long hash(int x, int y) {
		return (long) x * 1000 + y;
	}
}
