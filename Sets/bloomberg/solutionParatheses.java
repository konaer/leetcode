package z;

import java.util.*;

public class solutionParatheses {
	public static List<String> find(String str){
		List<String> res = new ArrayList<>();
		if(str.length() == 0) return res;
		
		int count = 0;
		int max = maxCount(str);
		for(char c : str.toCharArray()){
			if(c == '(' || c == '{'  || c == '['){
				count++;
				str = "";
			} else if( c == ')' || c == '}'  || c == ']'){				
				if(count == max) {
					res.add(str);
				}
				count--;
			} else {
				str += c;
			}		
		}
		return res;
	}

	private static int maxCount(String str) {
		int count = 0;
		int max = 0;
		for(char c : str.toCharArray()){
			if(c == '(' || c == '{'  || c == '['){
				count++;
				max = Math.max(count , max);
			}
			else if( c == ')' || c == '}'  || c == ']'){
				count--;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		String str = "abc(def)ghi[jk(l)()]mno[(pqr)]";
		List<String> ans = find(str);
		for (String s : ans) {
			if (s.equals("")) {
				System.out.println("haha");
			} else {
				System.out.println(s);
			}
		}
	}
}
