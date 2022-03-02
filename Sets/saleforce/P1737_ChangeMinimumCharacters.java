package saleforce;

public class P1737_ChangeMinimumCharacters {
	public int minCharacters(String a, String b) {
		int[] acnt = new int[26];
		int[] bcnt = new int[26];
		int an = a.length(), bn = b.length();
		
		for (char c : a.toCharArray()) {
			acnt[c - 'a']++;
		}
		
		for (char c : b.toCharArray()) {
			bcnt[c - 'a']++;
		}
		
		//注意z不能包括在里面
		int asum = 0, bsum = 0;
		int ans = Integer.MAX_VALUE, ans1 = ans, ans2 = ans;
		
		for (int i = 0; i < 25; i++) {
			asum += acnt[i];
			bsum += bcnt[i];
			
			ans1 = Math.min(an - asum + bsum, bn - bsum + asum);
			ans2 = an - acnt[i] + bn - bcnt[i];
			
			ans = Math.min(ans, Math.min(ans1, ans2));
		}
		//别忘了最后还有，都变成z的情况
		ans =  Math.min(ans, an - acnt[25] + bn - bcnt[25]);
		return ans;
    }
}
