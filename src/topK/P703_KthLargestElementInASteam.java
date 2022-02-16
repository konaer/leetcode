package topK;

public class P703_KthLargestElementInASteam {
	//时间 建堆时间nlogk， 后面每次get插入是logk时间
	//空间  优先队列储存k个元素， o(k)
	private Queue<Integer> heap = null;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        while (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }

}
