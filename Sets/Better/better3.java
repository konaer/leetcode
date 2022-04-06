package z;

public class better3 {
	public static int delete(int n) {
		if (n > 0) {
			String s = String.valueOf(n);
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '5') {
					s = s.substring(0, i) + s.substring(i + 1);
					return Integer.parseInt(s);
				}
			}
		} else {
			String s = String.valueOf(Math.abs(n));
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == '5') {
					s = s.substring(0, i) + s.substring(i + 1);
					return 0 - Integer.parseInt(s);
				}
			}
		}
		return n;
	}
	
	public static void main(String[] args) {
		int n = -50;
		System.out.println(delete(n));
	}
}
