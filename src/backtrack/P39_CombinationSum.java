package backtrack;

import java.util.*;

public class P39_CombinationSum {
	
	//时间复杂度，最差情况，每个都是解，这时候有2^n个解，放入list需要n，一共需要n*2^n
	//实际远比这个小，因为有pruning，实际是每个可行解的长度之和
	
	//空间：递归栈，最差情况，是target层
//	List<List<Integer>> ans = new ArrayList<>();
//    List<Integer> list = new ArrayList<>();
//
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        backtrack(candidates, target, 0);
//        return ans;
//    }
//
//    private void backtrack(int[] candidates, int target, int index) {
//        if (index == candidates.length) {
//            return;
//        }
//
//        if (target == 0) {
//            ans.add(new ArrayList<>(list));
//            return;
//        }
//
//        backtrack(candidates, target, index + 1);
//
//        if ((target - candidates[index]) >= 0) {
//            list.add(candidates[index]);
//            backtrack(candidates, target - candidates[index], index);
//            list.remove(list.size() - 1);
//        }
//    }
	
	
	
	
	List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return ans;
    }
    
    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            //这里错了一次，注意是i，不是index
        	if (target < candidates[i]) {
                break;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}
