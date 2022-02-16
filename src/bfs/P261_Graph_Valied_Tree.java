package bfs;

import java.util.*;

public class P261_Graph_Valied_Tree {
	public boolean validTree(int n, int[][] edges) {
        //树是n个点，n- 1条边
		if (n == 0 || edges.length != (n - 1)) {
        	return false;
        }
        
        Map<Integer,Set<Integer>> graph = findGraph(n, edges);
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        
        while (!queue.isEmpty()) {
        	int node = queue.poll();
        	for (int neighbor : graph.get(node)) {
        		if (!set.contains(neighbor)) {
        			queue.offer(neighbor);
        			set.add(neighbor);
        		}
        	}
        }
        //注意不需要计数器了，set的size方法就是干这个的
        return set.size() == n;        
    }
	
	private Map<Integer, Set<Integer>> findGraph(int n, int[][] edges) {
		Map<Integer,Set<Integer>> graph = new HashMap<>();		
		for (int i = 0; i < n; i++) {
			graph.put(i, new HashSet<>());
		}
		for (int i = 0; i < edges.length; i++) {
			int v = edges[i][0];
			int u = edges[i][1];
			graph.get(v).add(u);
			graph.get(u).add(v);			
		}
		return graph;
    }
}
