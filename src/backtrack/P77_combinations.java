package backtrack;

import java.util.List;

public class P77_combinations {
	
	//time 每次进list需要n时间， 一共 n的k个相乘次
	//space n 栈空间
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> list = new ArrayList<>();
	
	public List<List<Integer>> combine(int n, int k) {
		dfs(n, k, 1);
		return ans;
    }
	
	private void dfs(int n, int k, int index) {
		if (list.size() == k) {
			ans.add(new ArrayList<>(list));
			return;
		}
		
		for (int i = index; i <= n; i++) {
			list.add(i);
			dfs(n, k, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
