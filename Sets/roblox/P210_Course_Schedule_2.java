package z;

import java.util.*;

public class P210_Course_Schedule_2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[numCourses];
		
		for (int i = 0 ; i < numCourses; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		//这里是数组，忘了好几次了。
		for (int[] prerequisite : prerequisites) {
			graph.get(prerequisite[1]).add(prerequisite[0]);
			indegree[prerequisite[0]]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		
		int[] result = new int[numCourses];
		int count = 0;
		while (!queue.isEmpty()) {
			int preCourse = queue.poll();
			result[count] = preCourse;
			count++;
			for (int course : graph.get(preCourse)) {
				indegree[course]--;
				if (indegree[course] == 0) {
					queue.offer(course);
				}
			}
		}		
		return count == numCourses ? result : new int[0];
    }
}
