package String;

import java.util.List;

public class P6_ZigZagConversion {
	//time n
	//space n
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		
		int row = 0;
		boolean isDown = false;
		
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			rows.add(new StringBuilder());
		}
		
		for (char c : s.toCharArray()) {
			rows.get(row).append(c);
			if (row == 0 || row == numRows - 1) {
				isDown = !isDown;
			}
			row += (isDown ? 1 : -1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (StringBuilder r : rows) {
			sb.append(r);
		}
		return sb.toString();
    }
}
