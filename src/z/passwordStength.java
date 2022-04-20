package z;

import java.util.*;

//https://www.1point3acres.com/bbs/thread-885221-1-1.html


public class passwordStength {
	public static long find(String password) {
		Map<Character,Integer> mp=new HashMap<>();
		int tmp=1;
		long count=1;
		mp.put(password.charAt(0), 1);
		for(int i = 1; i < password.length(); i++){
			tmp += 1 + i - mp.getOrDefault(password.charAt(i), 0);
			mp.put(password.charAt(i),i+1);
			count += tmp;
		}
		return count;
	}
	
	public static long find1(String s) {
		Map<Character,Integer> memo = new HashMap<>();
		int dp = 1;
		long ans = 1;
		memo.put(s.charAt(0), 1);
		for(int i = 1; i < s.length(); i++){
			dp += 1 + i - memo.getOrDefault(s.charAt(i), 0);
			memo.put(s.charAt(i), i + 1);
			ans += dp;
		}
		return ans;
	}
	
	public static long find2(String s) {
		int n = s.length();
		int[] last = new int[26];
		int[] dp = new int[n];
		long ans = 0;
		
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (i == 0) {
				dp[0] = 1;
			} else {
				dp[i] = dp[i - 1] + i + 1 - (last[index]);
			}
			last[index] = i + 1;
			ans += dp[i];
		}
		return ans;
	}
	
	public static void main(String[] args) {
		String s = "test";
		System.out.println(find(s));
		System.out.println(find1(s));
		System.out.println(find2(s));
	}
}
