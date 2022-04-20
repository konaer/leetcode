package z;

public class N1519_NumberNodesintheSubTreeWiththeSameLabel {
	//time nc c是26，
	//space nc
	public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] edge : edges) {
            int node0 = edge[0], node1 = edge[1];
            List<Integer> list0 = map.getOrDefault(node0, new ArrayList<Integer>());
            List<Integer> list1 = map.getOrDefault(node1, new ArrayList<Integer>());
            list0.add(node1);
            list1.add(node0);
            map.put(node0, list0);
            map.put(node1, list1);
        }
        int[] counts = new int[n];
        boolean[] visited = new boolean[n];
        depthFirstSearch(0, counts, visited, map, labels);
        return counts;
    }

    public int[] depthFirstSearch(int node, int[] counts, boolean[] visited, Map<Integer, List<Integer>> map, String labels) {
        visited[node] = true;
        int[] curCounts = new int[26];
        curCounts[labels.charAt(node) - 'a']++;
        List<Integer> nodesList = map.get(node);
        for (int nextNode : nodesList) {
            if (!visited[nextNode]) {
                int[] childCounts = depthFirstSearch(nextNode, counts, visited, map, labels);
                for (int i = 0; i < 26; i++) {
                    curCounts[i] += childCounts[i];
                }
            }
        }
        counts[node] = curCounts[labels.charAt(node) - 'a'];
        return curCounts;
    }
}
