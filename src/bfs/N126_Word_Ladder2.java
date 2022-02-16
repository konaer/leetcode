package bfs;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class N126_Word_Ladder2 {
	
	List<List<String>> ans = new ArrayList<>();
	Map<String, List<String>> edge = new HashMap<>();
	Map<String, Integer> distance = new HashMap<>();
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> words = new HashSet<>(wordList);
		
		words.add(beginWord);
		bfs(endWord, words);
		dfs(beginWord, endWord);
		return ans;
    }
	
	private void bfs(String start, Set<String> words) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		distance.put(start, 0);
		for (String word : words) {
			edge.put(word, new ArrayList<>());
		}
		
		while(!queue.isEmpty()) {
			String s = queue.poll();
			List<String> neighbors = findNeighbor(s, words);
			for (String neighbor : neighbors) {
				edge.get(neighbor).add(s);
				distance.computeIfAbsent(neighbor, k -> distance.get(s) + 1);
				queue.offer(neighbor);
			}
		}	
	}
	
	private void dfs(String s, String end) {
		List<String> path = new ArrayList<>();
		path.add(s);
		if (s.equals(end)) {
			ans.add(new ArrayList<>(path));
		}
		for (String neighbor : edge.get(s)) {
			if (distance.containsKey(neighbor) 
					&& distance.get(s) == distance.get(neighbor) + 1);
			dfs(neighbor, end);
		}
		path.remove(path.size() - 1);
	}
	
	private List<String> findNeighbor (String s, Set<String> words) {
		List<String> neighbors = new ArrayList<>();
		
		for (int i = 0; i < s.length(); i++) {
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (ch != s.charAt(i)) {
					String neighbor = s.substring(0, i)
							+ ch + s.substring(i + 1);
					if (words.contains(neighbor)) {
						neighbors.add(neighbor);
					}
				}
			}
		}
		return neighbors;
	}
}
