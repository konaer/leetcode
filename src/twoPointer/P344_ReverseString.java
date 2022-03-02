package twoPointer;

public class P344_ReverseString {
	public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            swap(s, l++, r--);
        }
    }

    private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
