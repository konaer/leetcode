package z;

//https://www.1point3acres.com/bbs/thread-885221-1-1.html

import java.util.*;

public class ThreePackages {
	public static List<List<String>> getShipment(List<List<String>> shipments) {List<List<String>> result = new ArrayList<>();
		Queue<String> queue = new ArrayDeque<>();
		for (List<String> shipment : shipments) {
			String shipData = shipment.get(0);
			if (shipData.equals( "INSERT")) {
				queue.add(shipment.get(1));
			} else {
				List<String> data = new ArrayList<>();
				if (queue.size() < 3) {
					data.add("N/A");
				} else {
					for (int i = 0; i < 3; i++) {
						data.add(queue.poll());
					}
				}
				result.add(data);
			}
		}
		return result;
	}
}
