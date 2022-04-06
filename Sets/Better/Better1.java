package z;

import java.util.ArrayList;
import java.util.List;

public class Better1 {
	
	public static String getDate(String s, int k) {
		
		List<String> list = new ArrayList<>();
		list.add("Sun");
		list.add("Mon");
		list.add("Tue");
		list.add("Wed");
		list.add("Thu");
		list.add("Fri");
		list.add("Sat");
		
		int i = list.indexOf(s);
		return list.get((i + k) % 7);
	}
	
	public static void main(String[] args) {
		String s = "Sat";
		int k = 23;
		System.out.println(getDate(s, k));
	}
}
