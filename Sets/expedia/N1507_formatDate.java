package z;

public class N1507_formatDate {
	//o(l)
	
	String[] mon = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	public String reformatDate(String date) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < mon.length; i++) {
			map.put(mon[i], i + 1);
		}

		String[] arr = date.split(" ");
		int year = Integer.parseInt(arr[2]);
		int month = map.get(arr[1]);
		int day = Integer.parseInt(arr[0].substring(0, arr[0].length() - 2));
		return String.format("%d-%02d-%02d", year, month, day);
	}
}
