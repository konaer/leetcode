package z;

public class N1244_DesignALeaderboard {
	private HashMap<Integer, Integer> scores = null;

	public Leaderboard() {
        scores = new HashMap<Integer, Integer>();
    }

	public void addScore(int playerId, int score) {
		scores.put(playerId, scores.getOrDefault(playerId, 0) + score);
	}

	public int top(int K) {
        PriorityQueue<Integer> pq = PriorityQueue<>((a, b) -> scores.get(a) - scores.get(b));
        
        for (int id : scores.keySet()) {
            pq.offer(id);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().mapToInt(i -> i).sum();
	}

	public void reset(int playerId) {
		scores.put(playerId, 0);
	}
}
