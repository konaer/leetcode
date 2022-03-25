package z;

import java.util.Scanner;

/*题目
 *两个数，x, y。 从0~x的数，每个位数相加等于y的一共有几个？ 
 */



public class C1 {
	public static int findNumber(int x, int y) {
		if (y == 0) {
			return 1;
		}
		
		if (x == 0) {
			return 0;
		}
		
		int ans = 0;
		for (int i = 0; i <= x; i++) {
			int sum = 0, num = i;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			if (sum == y) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("input");
		int x = s.nextInt();
		System.out.println("input");
		int y = s.nextInt();
		int ans = findNumber(x, y);
		System.out.println(ans);
		s.close();
	}
}
