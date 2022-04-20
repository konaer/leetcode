package z;

// https://www.1point3acres.com/bbs/thread-882190-1-1.html

import java.util.Deque;
import java.util.*;

public class imblance {
	public static int find(int k, int[] weights) {
	    int n = weights.length;
	    Deque<Integer> min = new LinkedList<>(); // incr monotonic queue
	    Deque<Integer> max = new LinkedList<>(); // decr monotonic queue

	    int j = 0, count = 0;
	    for (int i = 0; i < n; i++) {
	        while (!min.isEmpty() && weights[min.peekLast()] >= weights[i]) { 
	        	min.removeLast();
	        }
	        min.add(i);
	        while (!max.isEmpty() && weights[max.peekLast()] <= weights[i]) {
	        	max.removeLast();
	        }
	        max.add(i);

	        // move the j to ensure the max - min > k
	        while (weights[max.peekFirst()] - weights[min.peekFirst()] > k) {
	            if (max.peekFirst() <= j) {
	            	max.removeFirst();
	            }
	            if (min.peekFirst() <= j) {
	            	min.removeFirst();
	            }
	            j++;
	        }
	        // if segment[j,i] is valid, then segment[j+1,i] to segment[i,i] are valid. 
	        // therefore, just sum it up
	        count += i - j + 1;
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		int k = 3;
		int[] weights = {1,3,6};
		System.out.println(find(k, weights));
	}
}
