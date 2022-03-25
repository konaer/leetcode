package z;

public class P809_ExpressiveWords {
	//time m + nK K是一共有几个word
	//space 1
	public int expressiveWords(String s, String[] words) {
		int ans = 0;
		for (String word : words) {
			if (isValid(s, word)) {
				ans++;
			}
		}
		return ans;
    }
	
	private boolean isValid(String s, String t) {
		int m = s.length(), n = t.length();
		
		if (m < n) {
			return false;
		}
		
		int i = 0, j = 0;
		while (i < m && j < n) {
			
			char c1 = s.charAt(i++);
			char c2 = t.charAt(j++);
			
			int cnt1 = 1;
			while (i < m && c1 == s.charAt(i)) {
				cnt1++;
				i++;
			}
			
			int cnt2 = 1;
			while (j < n && c2 == t.charAt(j)) {
				cnt2++;
				j++;
			}
			
			if (c1 != c2 || cnt1 < cnt2 || (cnt1 < 3 && cnt1 != cnt2)) {
				return false;
			}
		}
		//注意判断这个，必须要走到最后
		return i == m && j == n;
	}
}
