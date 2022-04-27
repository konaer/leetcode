package z;

public class N438FindAllAnagramsInAString {
	//time O(m+(n−m)×Σ)，其中 n 为字符串 s 的长度，m 为字符串 p 的长度，Σ 为所有可能的字符数
	public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();

        if (m < n) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < n; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < m - n; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + n) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }
}
