package z;

// https://www.1point3acres.com/bbs/thread-882830-1-1.html

public class kindleDirectPublish {
	public static int find(String input) {
		int count = 0;
		for (int i = 1; i <= input.length() - 2; i += 2) {
			if (isBalanced(input, 0, i) && isBalanced(input, i + 1, input.length() - 1))
				count++;
		}
		return count;
	}

	public static boolean isBalanced(String input, int start, int end) {
		int parenLeftCount = 0;
		int bracketLeftCount = 0;
		int question = 0;

		for (int i = start; i <= end; i++) {
			char c = input.charAt(i);
			if (c == '(')
				parenLeftCount++;
			if (c == ')')
				parenLeftCount--;
			if (c == '[')
				bracketLeftCount++;
			if (c == ']')
				bracketLeftCount--;
			if (c == '?')
				question++;
		}

		if (Math.abs(parenLeftCount) + Math.abs(bracketLeftCount) - question == 0) {
			return true;
		}

		int difference = question - Math.abs(parenLeftCount) - Math.abs(bracketLeftCount);
		if (difference > 0 && difference % 2 == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = "(((?";
		System.out.println(find(s));
	}
}
