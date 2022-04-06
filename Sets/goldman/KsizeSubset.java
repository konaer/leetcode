package z;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.1point3acres.com/bbs/thread-856742-1-1.html

public class KsizeSubset {
	
	// 时间 n* 2^n, 一共2^n个答案，每个放入list需要n时间
	// 空间 stack 空间，需要 n 空间
	static List<List<Character>> ans = new ArrayList<>();
    static List<Character> list = new ArrayList<>();
    
    public static List<List<Character>> find(String s, int k) {
    	char[] nums = s.toCharArray();
    	Arrays.sort(nums);
    	
    	dfs(nums, 0, false, k);
    	return ans;
    }
    
    private static void dfs(char[] nums, int index, boolean visited, int k) {
    	if (index == nums.length) {
    		if (list.size() == k) {
    			ans.add(new ArrayList<>(list));
    		}
    		return;
    	}
    	
    	dfs(nums, index + 1, false, k);
    	if (index != 0 && nums[index] == nums[index - 1] && !visited) {
    		return;
    	}
    	list.add(nums[index]);
    	dfs(nums, index + 1, true, k);
    	list.remove(list.size() - 1);
    }
    
    public static void main(String[] args) {
		String s = "abcdefghi";
		int k = 3;
		List<List<Character>> ans = find(s, k);
		for (List<Character> an : ans) {
			System.out.println(an);
		}
	}
}
