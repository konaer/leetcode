package z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/discuss/interview-question/424737/photo-album-problem

public class PhotoAlbum {
//	public static int[] find(int[] index, int[] identity) {
//		List<Integer> ans = new LinkedList<>();
//		for (int i = 0; i < index.length; i++) {
//			ans.add(index[i], identity[i]);
//		}
//		return ans.stream().mapToInt(i -> i).toArray(); 
//	}
	
	public static int[] find(int[] index, int[] identity) {
		int[] res = new int[identity.length];
		Arrays.fill(res, -1);
		for (int i = 0; i< identity.length; i++) {
			int idx = index[i];
			if (res[idx] != -1) {	
				int old = res[idx];
				int next = idx+1;
				while (res[next] != -1) {
					int tmp = res[next];
					res[next] = old;
					old = tmp;
					next++;
				}
				res[next] = old;
			};
			// fill 
			res[idx] = identity[i];
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] index = {0,1,2,1,2};
		int[] identity = {0,1,2,3,7};
		System.out.println(Arrays.toString(find(index, identity)));
	}
}
