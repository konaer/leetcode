package bfs;

import java.util.*;

//BFS时间复杂度 o(m + n) 空间复杂度（m + n）, 遍历图的时间复杂度都是（m+n）
public class P207_Course_Schedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegrees = new int[numCourses];
		
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[1]).add(prerequisite[0]);
			indegrees[prerequisite[0]]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0) {
				queue.offer(i);
			}
		}
		
		int count = 0;
		while (!queue.isEmpty()) {
			int preCourse = queue.poll();
			count++;
			for (int course : graph.get(preCourse)) {
				indegrees[course]--;
				if (indegrees[course] == 0) {
					queue.offer(course);
				}
			}
		}
		return count == numCourses;
    }
}
