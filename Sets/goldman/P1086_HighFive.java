package z;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class P1086_HighFive {
	 public int[][] highFive(int[][] items) {
		 int k = 5;
		 Map<Integer, PriorityQueue<Integer>> map = new TreeMap<>();
		 for (int[] item : items) {
			 int id = item[0];
			 int score = item[1];
			 map.computeIfAbsent(id, key -> new PriorityQueue<>((a, b) -> b - a));
			 map.get(id).offer(score);
		 }
		 List<int[]> ans = new ArrayList<>();
		 for (int id : map.keySet()) {
			 int sum = 0;
			 for (int i = 0; i < 5; i++) {
				 sum += map.get(id).poll();				 
			 }
             ans.add(new int[] {id, sum / k});
		 }
		 return ans.toArray(new int[ans.size()][]);
	 }
}
