package z;

public class N1396_DesignUndergroundSystem {
	//time都是o(1)
	//space map space, 0(s^2 + people)
	private Map<Integer, Pair<String, Integer>> start = null;
	private Map<String, Pair<Integer, Integer>> total = null;
	
	public UndergroundSystem() {
		start = new HashMap<>();
		total = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
    	start.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
    	String startStation = start.get(id).getKey();
    	Integer startTime = start.get(id).getValue();
    	String key = generateKey(startStation, stationName);
    	
    	Pair<Integer, Integer> sumData = total.getOrDefault(key, new Pair<>(0, 0));
    	Integer totalTime = sumData.getKey() + (t - startTime);
    	Integer totalPeople = sumData.getValue() + 1;
    	total.put(key, new Pair<>(totalTime, totalPeople));
    }
    
    public double getAverageTime(String startStation, String endStation) {
    	String key = generateKey(startStation, endStation);
    	Integer totalTime = total.get(key).getKey();
    	Integer totalPeople = total.get(key).getValue();
    	return totalTime / (double) totalPeople;
    }
    
    private String generateKey(String startStation, String endStation) {
    	return startStation + ":" + endStation; 
    }	
}
