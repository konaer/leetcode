package z;

public class P1200_MinimumAbsoluteDifference {
	public List<List<Integer>> minimumAbsDifference(int[] arr) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(arr);
		
		int minD = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int diff = arr[i + 1] - arr[i];
			if (diff == minD) {
				ans.add(Arrays.asList(arr[i], arr[i + 1]));
			} else if (diff < minD) {
				ans = new ArrayList<>();
				ans.add(Arrays.asList(arr[i], arr[i + 1]));
				minD = diff;
			} else {
				continue;
			}
		}
		return ans;
    }
}
