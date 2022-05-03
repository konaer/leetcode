package z;

public class P1583_CountUnhappyFriends {
	//时空都是 n^2
	
	public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
		//order[i][j] 表示朋友 jj 在 ii 的朋友列表中的亲近程度下标
		
		int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
}
