package z;

public class N1347_MinimumNumberStepsMakeTwoStringsAnagram {
	public int minSteps(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        
        int ans = 0;
        for (char c : t.toCharArray()) {
        	if (arr[c - 'a'] == 0) {
        		ans++;
        	} else {
        		arr[c - 'a']--;
        	}
        }
        return ans;
    }
}
