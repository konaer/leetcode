package SingleScan;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class P218_TheSkyLine {
	//时间 priorityqueue的删除时间是n，所以总时间是n^2
	//空间 list空间n，queue空间n, 总体是n
	public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        List<int[]> list = new ArrayList<>();
        
        for (int[] building : buildings) {
        	list.add(new int[] {building[0], building[2]});
        	list.add(new int[] {building[1], -building[2]});
        }
        
        Collections.sort(list, (a, b) -> {
        	return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int pre = 0;
        for (int[] height : list) {
        	if (height[1] > 0) {
        		pq.offer(height[1]);
        	} else {
        		pq.remove(-height[1]);
        	}
        	int cur = pq.peek();
        	if (cur != pre) {
        		ans.add(List.of(height[0], cur));
        		pre = cur;
        	} 
        }
        return ans;
    }
}
