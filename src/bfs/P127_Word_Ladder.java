package bfs;

import java.util.*;

public class P127_Word_Ladder {
	//时间nc^2, bfs需要nc个元素遍历，生成哈希表需要nc^2的时间，因为查询contains，是 string.size的时间，不是0（1）的 
	//空间 nc^2, map中一共nc个元素，每个的长度是c
	Map<String, Integer> map = new HashMap<>();
	List<List<Integer>> edge = new ArrayList<>();
	int idNum = 0;
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		addEdge(beginWord);
		for (String word : wordList) {
			addEdge(word);
		}
		if (!map.containsKey(endWord)) {
			return 0;
		}
		
		int beginID = map.get(beginWord);
		int endID = map.get(endWord);
		int[] step = new int[idNum];
		Arrays.fill(step, idNum);
		
		step[beginID] = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(beginID);
		
		while (!queue.isEmpty()) {
			int id = queue.poll();
			if (id == endID) {
				return step[id] / 2 + 1;
			}
			for (int neighbor : edge.get(id)) {
				if (step[neighbor] == idNum) {
					step[neighbor] = step[id] + 1;
					queue.offer(neighbor);
				}
			}
		}
		return 0;
		
		
	}
	
	private void addEdge(String word) {
		addWord(word);
		char[] array = word.toCharArray();
		int id1 = map.get(word);
		for (int i = 0; i < array.length; i++) {
			char temp = array[i];
			array[i] = '*';
			String nWord = new String(array);
			addWord(nWord);
			int id2 = map.get(nWord);
			edge.get(id1).add(id2);
			edge.get(id2).add(id1);
			//别忘了改回去这一步
			array[i] = temp;
		}
	}
	
	private void addWord(String word) {
		if (!map.containsKey(word)) {
			map.put(word, idNum);
			idNum++;
			edge.add(new ArrayList<>());
		}
	}

}
