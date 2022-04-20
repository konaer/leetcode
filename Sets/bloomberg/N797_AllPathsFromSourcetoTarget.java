package z;

public class N797_AllPathsFromSourcetoTarget {
	//路径数2^n,每个长度n，一共 2^n*n;
	//space n
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Deque<Integer> dq = new ArrayDeque<Integer>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dq.offerLast(0);
        dfs(graph, 0, graph.length - 1);
        return ans;
    }

    public void dfs(int[][] graph, int x, int n) {
        if (x == n) {
            ans.add(new ArrayList<Integer>(dq));
            return;
        }
        for (int y : graph[x]) {
            dq.offerLast(y);
            dfs(graph, y, n);
            dq.pollLast();
        }
    }
}
