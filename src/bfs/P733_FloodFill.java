package bfs;

public class P733_FloodFill {
	//最坏情况下遍历，时间mn
	//空间 queue空间，mn
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] xBias = {0, 0, 1, -1};
        int[] yBias = {1, -1, 0 ,0};

        int temp = image[sr][sc];
        if (temp == newColor) {
            return image;
        }
        
        int n = image[0].length;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(sr * n + sc);
        while (!queue.isEmpty()) {
            int num = queue.poll();
            sr = num / n;
            sc = num % n;
            image[sr][sc] = newColor;
            for (int i = 0; i < xBias.length; i++) {
                int nsr = sr + xBias[i];
                int nsc = sc + yBias[i];
                if (isValid(image, nsr, nsc, temp)) {
                    image[nsr][nsc] = newColor;
                    queue.offer(nsr * n + nsc);
                }
            }
        }
        return image;
    }

    private boolean isValid(int[][] image, int i, int j, int temp) {
        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != temp) {
            return false;
        }
        return true;
    }
    
    
    //dfs
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    	int temp = image[sr][sc];
    	if (temp == newColor) {
    		return image;
    	}
    	dfs(image, sr, sc, newColor, temp);
    	return image;   		
    }
    
    private void dfs(int[][] image, int sr, int sc, int newColor, int temp) {
    	if (!isValid(image, sr, sc, temp)) {
    		return;
    	}
    	
    	image[sr][sc] = newColor;
    	dfs(image, sr + 1, sc, newColor, temp);
    	dfs(image, sr - 1, sc, newColor, temp);
    	dfs(image, sr, sc + 1, newColor, temp);
    	dfs(image, sr, sc - 1, newColor, temp);
    }
    
    private boolean isValid (int[][] image, int i, int j, int temp) {
    	if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != temp) {
    		return false;
    	}
    	return true;
    }
}
