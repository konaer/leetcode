
import java.util.*;

class Person {
    
	static Map<String, Person> map = new HashMap<>();
	int age;
	int gender;
	
	public Person(int age, int gender) {
		this.age = age;
		this.gender = gender;
	}
	
	public int sum() {
		return age + gender;
	}
	
	public void create(String name) {
		if (map.containsKey(name)) {
			return;
		}
		
		Person cur = new Person(1,2);
		map.put(name, cur);
		return;
	}
	
	public void switch(String name) {
		if (!map.containsKey(name)) {
			return;
		}
	}

	
}


