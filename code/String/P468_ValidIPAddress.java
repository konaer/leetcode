package z;

public class P468_ValidIPAddress {
	
	//time 1
	//space 1
	public String validIPAddress(String queryIP) {
        if (queryIP.indexOf('.') != -1) {
        	return isIP4(queryIP);
        } else {
        	return isIP6(queryIP);
        }
    }
	
	private String isIP4(String queryIP) {
		String[] arr = queryIP.split("\\.", -1);
		if (arr.length != 4) {
			return "Neither";
		}
		
		for (String s : arr) {
			if (s.length() == 0 || s.length() > 3) {
				return "Neither";
			}
			if (s.charAt(0) == '0' && s.length() != 1) {
				return "Neither";
			}
			for (char c : s.toCharArray()) {
				if (!Character.isDigit(c)) {
					return "Neither";
				}
			}
			if (Integer.parseInt(s) > 255) {
				return "Neither";
			}
		}
		return "IPv4";
	}
	
	private String isIP6(String queryIP) {
		//-1是分成多少份，-1就是能份多少分多少，最后的空集也会给进来
		String[] arr = queryIP.split("\\:", -1);
		if (arr.length != 8) {
			return "Neither";
		}
		
		String digits = "01234567890abcdefABCDEF";
		for (String s : arr) {
			if (s.length() == 0 || s.length() > 4) {
				return "Neither";
			}
			for (char c : s.toCharArray()) {
				if (digits.indexOf(c) == -1) {
					return "Neither";
				}
			}
		}
		return "IPv6";
	}
}
