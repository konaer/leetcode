package z;
//https://www.1point3acres.com/bbs/thread-889914-1-1.html
import java.util.Arrays;

public class linuxCommandHistory {
	
	static int[] ans = new int[3];
	
	public static int[] find(String[] arr) {
		for (String s : arr) {
			dfs(arr, s);
		}
		return ans;
	}
	
	public static void dfs(String[] arr, String s) {
		if (s == "cp") {
			ans[0]++;
			return;
		}
		
		if (s == "ls") {
			ans[1]++;
			return;
		}
		
		if (s == "mv") {
			ans[2]++;
			return;
		}
		
		String sub = s.substring(1);
		int index = Integer.parseInt(sub) - 1;
		dfs(arr, arr[index]);
	}
	
	public static void main(String[] args) {
		String[] arr = {"ls", "cp", "mv", "mv", "mv", "!1", "!3", "!6"};
		int[] nums = find(arr);
		System.out.println(Arrays.toString(nums));
	}
}
