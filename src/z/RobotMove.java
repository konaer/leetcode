package z;
//https://www.1point3acres.com/bbs/thread-889914-1-1.html
public class RobotMove {
	public static String find(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == 'L') {
				count++;
			} else {
				count--;
			}
		}
		if (count > 0) {
			return "L";
		} else if (count < 0) {
			return "R";
		} else {
			return "";
		}
	}
	
	public static void main(String[] args) {
		String s = "LLRLLLRRRR";
		System.out.println(find(s));
	}
}
