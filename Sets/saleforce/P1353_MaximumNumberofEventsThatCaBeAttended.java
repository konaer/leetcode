package z;

import java.util.PriorityQueue;

public class P1353_MaximumNumberofEventsThatCaBeAttended {
	public int maxEvents(int[][] events) {
		int maxDay = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < events.length; i++) {
        	int[] event = events[i];
        	maxDay = Math.max(maxDay, event[1]);
        	
            List<Integer> list = map.getOrDefault(event[0], new ArrayList<>());
            list.add(i);
        	map.put(event[0], list);
        }
        
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= maxDay; i++) {
        	for (int index : map.getOrDefault(i, new ArrayList<>())) {
        		pq.offer(events[index][1]);
        	}
        	
        	while (!pq.isEmpty() && pq.peek() < i) {
        		pq.poll();
        	}
        	
        	if (!pq.isEmpty()) {
        		pq.poll();
        		ans++;
        	}
        }
        return ans;
    }
}
