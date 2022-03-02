import java.util.List;

public class Solution {
	//渐进时间 n * 2^2n, 一共2n个位置，每个位置有两种情况。每次放入string需要时间n
	//空间 n 回溯深度2n
	List<String> ans = new ArrayList<>();

	public List<String> generateParenthesis(int n) {
		dfs(n, 0, 0, new StringBuilder());
		return ans;
	}

	private void dfs(int n, int left, int right, StringBuilder sb) {
		if (sb.length() == 2 * n) {
			ans.add(sb.toString());
			return;
		}

		if (left < n) {
			sb.append('(');
			dfs(n, left + 1, right, sb);
			sb.deleteCharAt(sb.length() - 1);
		}

		if (right < left) {
			sb.append(')');
			dfs(n, left, right + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	// 第二种
//	List<String> ans = new ArrayList<>();
//
//	public List<String> generateParenthesis(int n) {
//		dfs(n, n, "");
//		return ans;
//	}
//
//	private void dfs(int left, int right, String s) {
//		if (left > right) {
//			return;
//		}
//		if (left == 0 && right == 0) {
//			ans.add(s);
//		}
//
//		if (left > 0) {
//			dfs(left - 1, right, s + '(');
//		}
//		if (right > 0) {
//			dfs(left, right - 1, s + ')');
//		}
//	}
}
