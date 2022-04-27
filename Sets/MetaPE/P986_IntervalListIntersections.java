package z;

import java.util.List;

public class P986_IntervalListIntersections {
	//时间 m+ n；
	//空间 l
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

		List<int[]> list = new ArrayList<>();
		int i = 0, j = 0;
		while (i < firstList.length && j < secondList.length) {
			int start = Math.max(firstList[i][0], secondList[j][0]);
			int end = Math.min(firstList[i][1], secondList[j][1]);
			if (start <= end) {
				list.add(new int[] { start, end });
			}
			
			//注意这里不是else，连着上面的情况也要判断并加i或j
			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else {
				j++;
			}

		}
		return list.toArray(new int[list.size()][]);
	}
}
