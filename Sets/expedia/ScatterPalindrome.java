package z;

import java.util.HashMap;
import java.util.Map;

import backtrack.ArrayList;

//https://leetcode.com/discuss/interview-question/431933/rubrik-oa-2019-scatter-palindrome

public class ScatterPalindrome {
	
	public static long find(String s) {
		if (s.length() == 0) {
			return 0;
		}
		
		long ans = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				if (isValid(s.substring(i, j))) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	private static boolean isValid(String s) {
		int[] arr = new int[26];
		for (char c : s.toCharArray()) {
			arr[c - 'a']++;
		}
		
		int count = 0;
		for (int num : arr) {
			if (num % 2 == 1) {
				count++;
			}
		}
		return count < 2;
	}
	
	//第二种解法
	private static long method3(String s){
	    int n = s.length();
	    int answer = 0;
	    Map<Integer, Integer> m=new HashMap<>();
	    m.put(0,1);

	    int x = 0;
	    for (char c : s.toCharArray()) {
	        int d = c - 'a';
	        x ^= 1 << d;
	        answer =answer+ m.getOrDefault(x,0);
	        for (int i = 0; i < 26; ++i) {
	            answer += m.getOrDefault(x ^ (1 << i),0);
	        }
	         m.put(x,m.getOrDefault(x,0)+1);
	    }
	    return answer;
	}
	
	public static void main(String[] args) {
		String s = "aabb";
		System.out.println(find(s));
		System.out.println(method3(s));
	}
}
