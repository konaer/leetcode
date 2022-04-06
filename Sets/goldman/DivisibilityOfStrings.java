package z;

//https://www.1point3acres.com/bbs/thread-854126-1-1.html

public class DivisibilityOfStrings {
	public static int findDivid(String s, String t) {
		int m = s.length(), n = t.length();
		if (m < n && m % n != 0) {
			return -1;
		}
		
		String test = s.replaceAll(t, "");
		if (!(test.length() == 0)) {
			return -1;
		}
		
		for (int i = 1; i < n; i++) {
			String sub = t.substring(0, i);
			String rep = t.replaceAll(sub, "");
			if (rep.length() == 0) {
				return sub.length();
			}
		}
		return t.length();
	}
	
	public static void main(String[] args) {
		String s = "bcdbcdbcdbcd";
		String t = "b";
		System.out.println(findDivid(s, t));
	}
}
