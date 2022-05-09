package z;

import java.util.ArrayList;
import java.util.List;

public class evenToSumN {
	public static List<Long> maximumEvenSplit(long finalSum) {
		List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
        	return ans;
        }
        
        long i = 2;
        while (finalSum >= i) {
        	finalSum -= i;
        	ans.add(i);
        	i += 2;
        }
        ans.set(ans.size() - 1, ans.get(ans.size() - 1) + finalSum);
        return ans;
    }
}
