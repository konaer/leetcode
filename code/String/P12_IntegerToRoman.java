package z;

public class P12_IntegerToRoman {
	//time n = values.length
	//space n
	int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
	String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(symbols[i]);
			}
			
			if (num == 0) {
				break;
			}
		}
		
		return sb.toString();
	}
}
