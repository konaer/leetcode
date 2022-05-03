package z;

public class P1519_NumberNodesintheSubTreeWiththeSameLabel {
	//time nc c是26，
	//space nc
	 Map<Integer, List<Integer>> map = new HashMap<>();
	    boolean[] visited = null;
	    int[] ans = null;
	    
	    public int[] countSubTrees(int n, int[][] edges, String labels) {
	        for (int[] edge : edges) {
	            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
	            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
	        }
	        
	        ans = new int[n];
	        visited = new boolean[n];
	        dfs(0, labels);
	        return ans;
	    }
	    
	    private int[] dfs(int node, String labels) {
	        visited[node] = true;
	        int[] count = new int[26];
	        count[labels.charAt(node) - 'a']++;
	        for (int nNode : map.get(node)) {
	            if (!visited[nNode]) {
	                int[] nCount = dfs(nNode, labels);
	                for (int i = 0; i < 26; i++) {
	                    count[i] += nCount[i];
	                }
	            }
	        }
	        ans[node] = count[labels.charAt(node) - 'a'];
	        return count;
	    }
}
