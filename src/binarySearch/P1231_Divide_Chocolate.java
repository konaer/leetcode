package binarySearch;

public class P1231_Divide_Chocolate {
	public int maximizeSweetness(int[] sweetness, int k) {
        int min = 0;
		int max = 0;

		for (int sweet : sweetness) {
			min = Math.min(min, sweet);
			max += sweet;
		}
		max = max / (k + 1);

		while (min < max) {
			int mid = min + (max - min + 1) / 2;
			if (checkMid(sweetness, k, mid)) {
				min = mid;
			} else {
				max = mid - 1;
			}
		}
		return max;
    }
	
	//如果是true，mid就一定能取到。如果是false，mid一定取不到。
	private boolean checkMid(int[] sweetness, int k, int mid) {
		int count = 0;
		int sum = 0;

		for (int sweet : sweetness) {
			//如果小于就接着加，直到加到大于等于为止。最终结果是除了最后一组，前面的组全都大于等于这个数值。
			if (sum + sweet < mid) {
				sum += sweet;
			} else {
				sum = 0;
				count++;
			}
		}
		//大于K，说明还能至少可以退一刀，那么只要退最后一刀，就能保证全部大于mid了。
		return count > k;
	}
}
