package z;

public class N380_InsertDeleteGetRandomO1 {
	//平均o1，但是最坏情况仍是n，元素超过哈希表容量导致的重新分配
	Map<Integer, Integer> dict;
	List<Integer> list;
	Random rand = new Random();

	public RandomizedSet() {
	    dict = new HashMap();
	    list = new ArrayList();
	 }

	public boolean insert(int val) {
		if (dict.containsKey(val)) {
			return false;
		}
			
		dict.put(val, list.size());
		list.add(list.size(), val);
		return true;
	}

	public boolean remove(int val) {
		if (!dict.containsKey(val)) {
			return false;
		}

		// move the last element to the place idx of the element to delete
		int lastElement = list.get(list.size() - 1);
		int idx = dict.get(val);
		list.set(idx, lastElement);
		dict.put(lastElement, idx);
		// delete the last element
		list.remove(list.size() - 1);
		dict.remove(val);
		return true;
	}

	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
}
