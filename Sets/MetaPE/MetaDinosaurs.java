package z;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class MetaDinosaurs {
	
	public static void main(String[] args) {
		
		String f1 = "f1.csv";
		String f2 = "f2.csv";
		
		Map<Speed, List<String>> output = new HashMap<>();
		
		try {
			BufferReader bf1 = new BufferRearder(FileReader(f1));
			BufferReader bf2 = new BufferRearder(FileReader(f1));
			
			Map<String, Float> bipedal = new HashMap<>();
			String line = f2.readLine();
			line = f2.readLine();
			while (line != null) {
				String[] tokens = line.split(",");
				if ("bipedal".equals(tokens[2])) {
					bipedal.put(tokens[0], Float.parseFloat(tokens[1]));
				}
				line = f2.readLine();
			}
			
			Map<Speed, List<String>> output = new HashMap<>();
			line = f1.readLine();
			line = f1.readLine();
			while (line != null) {
				String[] tokens = line.split(",");
				String name = tokens[0];
				if (bipedal.containsKey(name)) {
					float stride = bipedal.get(name);
					float leg = Float.parseFloat(tokens[1]);
					float speed = (float)(((stride / leg) - 1) * Math.sqrt(leg * 9.8));
					output.put(speed, name);
				}
				line = f1.readLine();
			}
			
			for (Float f : output.keySet()) {
				System.out.println(output.get(f));
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not fount");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("IO problem");
		} finally {
			bf1.close();
			bf2.close();
		}	
	}
}
