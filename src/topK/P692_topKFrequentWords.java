package topK;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P692_topKFrequentWords {
	
	//时间，n时间计算每个单词频率， 每个logk时间插入堆，一共n个，所以是nlogk
	//加起来就是 n + nlogk， 取nlogk
	//还要考虑字符串长度，取平均长度为l， 时间复杂度为 l(nlogk)
	//哈希表空间n，堆空间k，取大的，n
	public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
        	int count = map.getOrDefault(s, 0) + 1;
        	map.put(s, count);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
        	if (map.get(a).equals(map.get(b))) {
        		return b.compareTo(a);
        	} else {
        		return map.get(a) - map.get(b);
        	}
        });
        
        for (String s : map.keySet()) {
        	pq.offer(s);
        	if (pq.size() > k) {
        		pq.poll();
        	}
        }
        
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
        	list.add(pq.poll());
        }
        
        Collections.reverse(list);
        return list;
    }
}
