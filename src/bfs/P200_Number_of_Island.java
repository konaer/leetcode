package bfs;

import java.util.*;

public class P200_Number_of_Island {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null) {
            return result;
        }
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    private void bfs(char[][] grid, int i, int j) {   
        int[] xBias = {0, 0, 1, -1};
        int[] yBias = {1, -1, 0, 0};
        int m = grid[0].length;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * m + j);
        grid[i][j] = '0';
        
        while (! queue.isEmpty()) {
            int num = queue.poll();
            i = num / m;
            j = num % m;
            
                        
            for (int k = 0; k < xBias.length; k++) {
                int new_i = i + xBias[k];
                int new_j = j + yBias[k];
                if (!isValid(grid, new_i, new_j)) {
                    continue; 
                }
                queue.offer(new_i * m + new_j);
                //不能等出队列的时候才变，因为有可能在队列里的时候，就已经影响判断过程了。
                grid[new_i][new_j] = '0';
            }
        }
    }
    
    private boolean isValid(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return false;
        }
        return true;
    }
}
