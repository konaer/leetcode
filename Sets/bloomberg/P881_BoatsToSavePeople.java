package z;

public class P881_BoatsToSavePeople {
	//time nlogn
	//space l
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int ans = 0;
        
        while(l <= r) {
        	ans++;
        	if (people[l] + people[r] <= limit) {
        		l++;
        	}
        	r--;
        }
        return ans;
    }
}
