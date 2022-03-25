package z;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MetaDinosaurs {
	
	public static void main(String[] args) {
		
		String f1 = "f1.csv";
		String f2 = "f1.csv";
		
		Map<String, Float> bipedal = new HashMap<>();
		Map<Speed, List<String>> output = new HashMap<>();
		
		try {
			BufferReader bf1 = new BufferRearder(FileReader(f1));
			BufferReader bf2 = new BufferRearder(FileReader(f1));
			
			
			
			
			
			
			
			
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
