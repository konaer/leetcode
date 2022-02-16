package SingleScan;

import java.util.List;

/*
//Definition for an Interval.
class Interval {
 public int start;
 public int end;

 public Interval() {}

 public Interval(int _start, int _end) {
     start = _start;
     end = _end;
 }
};
*/


public class P759_EmployeeFreeTime {
	//时间 nlogn, n是所有员工的区间数
	//空间 n，  list使用空间
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<int[]> list = new ArrayList<>();
        for (List<Interval> people : schedule) {
        	for (Interval time : people) {
        		list.add(new int[] {time.start, 1});
        		list.add(new int[] {time.end, -1});
        	}
        }
        
        Collections.sort(list, (a, b) -> {
        	//时间相同，应该把开始放前面，这样可以防止[1,1] 这样的情况出现
        	return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]; 
        });
        
        List<Interval> ans = new ArrayList<>();
        int count = 0, pre = -1;
        for (int[] event : list) {
        	if (count == 0 && pre >=0 && pre != event[0]) {
        		ans.add(new Interval(pre, event[0]));
        	}
        	count += event[1];
        	pre = event[0];
        }
        return ans;
    }
	
	//时间 nlogn
	//空间 n
	public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
		List<Interval> ans = new ArrayList<>();
		PriorityQueue<Interval> q = new PriorityQueue<>((a, b) -> a.start - b.start);
		
		for (List<Interval> list : schedule) {
			for (Interval interval : list) {
				q.offer(interval);
			}
		}
		
		Interval cur = q.poll();
		while (!q.isEmpty()) {
			if (cur.end >= q.peek().start) {
				cur.end = Math.max(cur.end, q.poll().end);
			} else {
				ans.add(new Interval(cur.end, q.peek().start));
				cur = q.poll();
			}
		}
		return ans;
	}
	
}
