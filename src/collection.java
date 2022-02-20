
public class collection {
	

	Queue<Integer> queue = new LinkedList<>();
	queue.offer();
	queue.poll();
	
	Deque<Integer> stack = new ArrayDeque<>();
	stack.push();
	stack.pop();
	stack.peek();
	
	Queue<Integer> heap = new PriorityQueue<>();
	heap.offer();
	heap.poll();
	
	Deque<Integer> deque = new ArrayDeque<>();
	deque.offerFirst();
	deque.pollFirst();
	Deque.peekFirst();
	
	Set<Integer> set = new HashSet<>();
	set.add();
	set.remove();
	set.contains();
	
	Map<Integer, Integer> map = new HashMap<>();
	map.put();
	map.remove();
	map.get();
	
}
