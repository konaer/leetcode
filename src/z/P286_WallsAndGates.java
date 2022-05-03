package z;

public class P286_WallsAndGates {
	public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    private void dfs(int[][] rooms, int i, int j, int index) {
        if (!isValid(rooms, i, j) || rooms[i][j] < index) {
            return;
        }
        
        if (index != 0 && rooms[i][j] <= index) {
        	return;
        }
        
        rooms[i][j] = index;
        dfs(rooms, i + 1, j, index + 1);
        dfs(rooms, i - 1, j, index + 1);
        dfs(rooms, i, j + 1, index + 1);
        dfs(rooms, i, j - 1, index + 1);
    }
    
    private boolean isValid(int[][] rooms, int i, int j) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length) {
            return false;
        }
        return true;
    }
}
