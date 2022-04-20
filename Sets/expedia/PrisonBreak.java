package z;

import java.util.*;

//https://www.evernote.com/client/snv?noteGuid=a46acf88-f8bf-4a0a-8ec6-99b6658da40a&noteKey=6aaeb71b181fe6b3&sn=https%3A%2F%2Fwww.evernote.com%2Fshard%2Fs337%2Fsh%2Fa46acf88-f8bf-4a0a-8ec6-99b6658da40a%2F6aaeb71b181fe6b3&title=HackerRank

public class PrisonBreak {
	public static long find(int n, int m, int[] h, int[] v) {
		boolean[] rows = new boolean[n + 1];
		boolean[] cols = new boolean[m + 1];
		
		for (int i : h) {
			rows[i] = true;
		}
		
		for (int i : v) {
			cols[i] = true;
		}
		
		int maxH = findMax(n, rows);
		int maxV = findMax(m, cols);
		return (long) maxH * maxV;
	}
	
	private static int findMax(int n, boolean[] rows) {
		int ans = 1, index = 1;
		for (int i = 1; i <= n; i++) {
			if (!rows[i]) {
				index = 1;
			} else {
				ans = Math.max(ans, ++index);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] h = {2};
		int[] v = {2};
		System.out.println(find(3,3, h, v));
	}
}
