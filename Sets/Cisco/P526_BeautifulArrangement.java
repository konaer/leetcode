package z;

import java.util.List;

public class P526_BeautifulArrangement {
	//time 预处理nums n^2, 回溯n!,所以总的是n!
	//space 栈空间n，数组n^2,所以是n^2
	List<Integer>[] nums;
	boolean[] visited;
	int ans = 0;
	
	public int countArrangement(int n) {
		nums = new List[n + 1];
        visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			nums[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (j % i == 0 || i % j == 0) {
					nums[i].add(j);
				}
			}
		}
		
		backtrack(1, n);
		return ans;
    }
	
	private void backtrack(int index, int n) {
		if (index == n + 1) {
			ans++;
			return;
		}
		
		for (int x : nums[index]) {
			if (!visited[x]) {
				visited[x] = true;
				backtrack(index + 1, n);
				visited[x] = false;
			}
		}
	}
}
