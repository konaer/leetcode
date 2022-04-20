package z;

import java.util.Map;
import java.util.Set;

public class P1487_MakingFileNamesUnique {
	//time ns
	//space ns
	public String[] getFolderNames(String[] names) {
		Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
        	String name = names[i];
        	if (map.containsKey(name)) {
        		int index = map.get(name) + 1;
        		String nName = name + "(" + index + ")";
        		while (map.containsKey(nName)) {
        			index++;
        			nName = name + "(" + index + ")";
        		}
        		map.put(name, index);
        		names[i] = nName;
        	} 
        	map.put(names[i], 0);
        }
        return names;
    }
}
