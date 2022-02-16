package hashTable;
import java.util.*;

class P170_TwoSum3_DataStructureDesign {
	
	private Map<Integer, Integer> map;
	
	//public twoSum
    public P170_TwoSum3_DataStructureDesign() {
    	this.map = new HashMap<>();
    }
    
    public void add(int number) {
    	map.put(number, map.getOrDefault(number, 0) + 1);
    }
    
    public boolean find(int value) {
    	for (Integer key : map.keySet()) {
    		int index = map.getOrDefault(value - key, 0);
    		if (index >= 2 || (index == 1 && (key * 2) != value)) {
    			return true;
    		}
    	}
    	return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
