package z;

public class P443_StringCompression {
	//time n
	//space 1
	public int compress(char[] chars) {
		int index = 0;
        for (int i = 0; i < chars.length;) {
            int j = i;
            while (j < chars.length && chars[i] == chars[j]) {
            	j++;
            }
            chars[index++] = chars[i];
            if (j - i > 1) {
            	String s = String.valueOf(j - i);
            	for (int k = 0; k < s.length(); k++) {
            		chars[index++] = s.charAt(k);
            	}
            }
            i = j;
        }
        return index;
    }
}
