package topK;

import java.util.Set;

public class P414_ThirdMaximumNumber {
	public int thirdMax(int[] nums) {
		//注意这里必须用TreeSet开头，不能用Set开头
		//时间n
		//空间3
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
        	set.add(num);
        	while (set.size() > 3) {
        		set.remove(set.first());
        	}
        }
        return set.size() != 3 ? set.last() : set.first();
    }
}
