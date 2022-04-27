package z;

import java.util.*;

public class generateMines {
	public static int[][] generateMines(int m, int n, int mineNum) {

		int range = m * n;
		int[] array = new int[range];
		for (int i = 0; i < range; i++) {
			array[i] = i;
		}
		int[] randomPoints = randomSelected(array, mineNum);
		int[][] result = new int[m][n];
		for (int i = 0; i < randomPoints.length; i++) {
			result[randomPoints[i] / m][randomPoints[i] % n] = 'X';
		}
		return result;
	}

	public static int[] randomSelected(int[] array, int num) {
        int[] temp = Arrays.copyOf(array, array.length);// 获得一个该数组的复制
        int length = temp.length;
        int left = length;
        while (length - left < num) {// length - left 为还需要计算多少次
            int i = (int) Math.floor(Math.random() * left--);// 随机选取一个元素，left 自减，这样不会覆盖上次产生的结果，并将下次选取的范围缩小
            int tmp = temp[i];// 将被选中的数与数组的最后一位进行调换
            temp[i] = temp[left];
            temp[left] = tmp;
        }
        return Arrays.copyOfRange(temp, 0, num > length ? length : num);// 从临时数组中复制出指定长度的数组
    }
}
