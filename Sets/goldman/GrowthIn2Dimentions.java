package z;

//https://www.1point3acres.com/bbs/thread-857943-1-1.html

public class GrowthIn2Dimentions {
	public static int find(String[] upRight) {
		int r = Integer.MAX_VALUE;
		int c = Integer.MAX_VALUE;
		
		for (String s : upRight) {
			String[] ns = s.split("\\s+");
			int nr = Integer.parseInt(ns[0]);
			int nc = Integer.parseInt(ns[1]);
			r = Math.min(r, nr);
			c = Math.min(c, nc);
		}
		return r * c;
	}
}
