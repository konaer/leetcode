package bfs;

import java.util.*;

public class P752_OpenTheLock {
	// 时间复杂度0（b^d * d^2 + md）
	// 数字一共b^d种，每个数字需要d时间旋转，d时间加入队列，所以广度优先所搜时间为b^d*d^2
	// 把deadends放入哈希表需要md

	// 空间复杂度0(b^d * d + m)
	// queue中最多需要b^d个字符串，每个是长度是d
	// deadend哈希表需要m空间来存储

	public int openLock(String[] deadends, String target) {
		int result = 0;
		Set<String> dead = new HashSet<>();
		for (String deadend : deadends) {
			dead.add(deadend);
		}

		String start = "0000";
		if (dead.contains(start)) {
			return -1;
		}

		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		queue.offer(start);
		set.add(start);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String num = queue.poll();
				// 一定注意string要用equals判
				if (num.equals(target)) {
					return result;
				}
				for (String neighbor : findNeighbor(num)) {
					if (!set.contains(neighbor) && !dead.contains(neighbor)) {
						queue.offer(neighbor);
						set.add(neighbor);
					}

				}
			}
			result++;
		}
		return -1;
	}

	private List<String> findNeighbor(String num) {
		List<String> list = new ArrayList<>();
		char[] array = num.toCharArray();
		for (int i = 0; i < array.length; i++) {
			char temp = array[i];
			array[i] = findNext(temp);
			list.add(new String(array));
			array[i] = findLast(temp);
			list.add(new String(array));
			array[i] = temp;
		}
		return list;
	}

	private char findNext(char x) {
		return x == '0' ? '9' : (char) (x - 1);
	}

	private char findLast(char x) {
		return x == '9' ? '0' : (char) (x + 1);
	}
}
