package z;

//https://www.chegg.com/homework-help/questions-and-answers/amazon-kindle-store-online-e-book-store-readers-choose-book-wide-range-categories-also-pro-q93238892

public class kindleStore {
	public static int find(int[] nums) {
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] == 1) {
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[k] == 0) {
								ans++;
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[j] == 0) {
						for (int k = j + 1; k < nums.length; k++) {
							if (nums[k] == 1) {
								ans++;
							}
						}
					}
				}
			}
		}
		return ans;
	}
	
	
	public static int find2(int[] nums) {
		if (nums.length < 3) {
			return 0;
		}
		
		int ans = 0;
		int n = nums.length;
		int cont0 = 0, cont1 = 0;
		int[] sum0 = new int[n];
		int[] sum1 = new int[n];
		
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				cont0++;
			} else {
				cont1++;
			}
			sum0[i] = cont0;
			sum1[i] = cont1;
		}
		
		ans = 0;
		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == 1) {
				ans += sum0[i] * (sum0[n - 1] - sum0[i]);			
			} else {
				ans += sum1[i] * (sum1[n - 1] - sum1[i]);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,0,1};
		System.out.println(find2(nums));
	}
}
