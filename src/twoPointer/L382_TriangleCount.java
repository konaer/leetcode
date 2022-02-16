package twoPointer;

import java.util.Arrays;

public class L382_TriangleCount {
	public int triangleCount(int[] S) {
        int count = 0;
		if (S == null || S.length < 3) {
        	return count;
        }
		Arrays.sort(S);
		for (int i = S.length - 1; i >= 0; i--) {
			int l = 0, r = i - 1;
			while (l < r) {
				if (S[l] + S[r] > S[i]) {
					count += r - l;
					r--;
				} else {
					l++;
				}
			}
		}
		return count;
    }
}
