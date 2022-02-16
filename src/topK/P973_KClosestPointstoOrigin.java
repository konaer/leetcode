package topK;

public class P973_KClosestPointstoOrigin {
	//时间 nlogk
	//空间 k
	public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int dis_a = a[0]*a[0] + a[1]*a[1];
            int dis_b = b[0]*b[0] + b[1]*b[1];
            return dis_b - dis_a;
        });

        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }
}
