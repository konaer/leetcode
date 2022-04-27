package z;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class dinasaurs {
	public static void main(String[] args) {
		
		String f1 = "f1.csv";
		String f2 = "f2.csv";
		
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		
		
		try {
			br1 = new BufferedReader(new FileReader(f1));
			br2 = new BufferedReader(new FileReader(f2));
			
			Map<String, Float> bipedal = new HashMap<>();
			String line = br2.readLine();
			line = br2.readLine();
			while (line != null) {
				String[] tokens = line.split(",");
				if ("bipedal".equals(tokens[2])) {
					bipedal.put(tokens[0], Float.parseFloat(tokens[1]));
				}
				line = br2.readLine();
			}
			
			Map<Float, String> output = new HashMap<>();
			line = br1.readLine();
			line = br1.readLine();
			while (line != null) {
				String[] tokens = line.split(",");
				String name = tokens[0];
				if (bipedal.containsKey(name)) {
					float stride = bipedal.get(name);
					float leg = Float.parseFloat(tokens[1]);
					float speed = (float)(((stride / leg) - 1) * Math.sqrt(leg * 9.8));
					output.put(speed, name);
				}
				line = br1.readLine();
			}
			
//			String fileName = "data\\log.txt"
//			Path path = Paths.get(fileName);
//			BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
//			for (Float f: output.keySet()) {
//				writer.write(String.valueOf(output.get(f)));
//			}
//			
//			for (Float f : output.keySet()) {
//				System.out.println(output.get(f));
//			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("file not fount");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("file not fount");
		} finally {
			try {
				br1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				br2.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
//			writer.close();
		}	
	}
}
