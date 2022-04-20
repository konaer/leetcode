package z;

public class StringPalindrome {
	public static int find(String input) {
		int i = 0, j = input.length() - 1;
		int diff = 0;
		while (i < j) {
			if (input.charAt(i) != input.charAt(j)) {
				diff++;
			}
			i++;
			j--;
		}
		boolean isInputLengthOdd = input.length() % 2 != 0;
		boolean isDiffCountOdd = diff % 2 != 0;
		// 输入数组是偶数项，并且不同的数量是奇数，不会组成回文串，e.g., "000111"
		if (!isInputLengthOdd && isDiffCountOdd) {
			return -1;
		}
		// swap一次会解决2组不同，所以除2
		int minSwap = diff / 2;
		// 当不同的数量是奇数的时候，需要多swap一次
		// 这种情况只可能是输入数组是奇数，e.g., "0100110"
		if (isDiffCountOdd) {
			minSwap += 1;
		}
		return minSwap;
	}
}

//刚做的SDEII OA 遇到第一个题地里没见过，最后有5个test cases没过，希望别挂
//题目：给定一个0和1组成的string，问min swipe能让这个string变成palindrome