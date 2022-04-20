package z;

import java.util.Arrays;

public class groupEngineers {
	public static int find(int t, int d, int[] nums) {
		int n = nums.length;
		if (t == 1) {
			return n;
		}
		
		int ans = 0;
		Arrays.sort(nums);
		int index = 0;
		for (int i = 1; i < n; i++) {
			while (nums[i] - nums[index] > d) {
				index++;
			}
			if (i - index + 1 == t) {
				ans++;
				index = i + 1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {1, 7, 18, 32, 65, 72, 90, 98, 100, 113, 146};
		int t = 3, d = 25;
		System.out.println(find(t, d, nums));
	}
}

//You are given 3 inputs
//
//int: teamSize:: representing the number of engineers to complete a team, otherwise the team does not count towards total
//
//1 <= teamSize <= 10^4 unsure about constraint
//int: maxDiff:: representing the maximum allowed gap in skill between the least skilled engineer on a team and the most skilled on the team
//
//1 <= maxDiff <= 100 unsure about constraint
//array[int]: skill:: representing the pool of engineers to build teams from, skill[i] being the skill level an engineer i
//
//1 <= pool of enginers <= 10^4 unsure about constraint
//1 <= skill[i] <= 100 unsure about constraint
//what is the maximum number of teams that can be constructed from the pool of engineers, respecting the maxDiff rule for each team?
//Example1:
//input: teamSize: 1, maxDiff: 1, skill: [34, 5, 72, 48, 15, 2]
//output: 6 ---> (resulting teams [[2], [5], [15], [34], [48], [72]])
//
//Example2:
//input: teamSize: 3, maxDiff: 20, skill: [34, 5, 72, 48, 15, 2]
//output: 1 ---> (resulting teams [[2, 5, 15]])
//
//Example3:
//input: teamSize: 3, maxDiff: 30, skill: [34, 5, 72, 48, 15, 2]
//output: 2 ---> (resulting teams [[2, 5, 15], [34, 48, 72]])
//
//Example4:
//input: teamSize: 3, maxDiff: 5, skill: [34, 5, 72, 48, 15, 2]
//output: 0 ---> (resulting teams [])
//
//Example5:
//input: teamSize: 3, maxDiff: 25, skill: [1, 7, 18, 32, 65, 72, 90, 98, 100, 113, 146]
//output: 3 ---> (resulting teams [[7, 18, 32], [65, 72, 90], [98, 100, 113]])