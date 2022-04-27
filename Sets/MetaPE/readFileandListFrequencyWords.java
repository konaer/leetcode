package z;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.*;

public class readFileandListFrequencyWords {
	
		
		public static String main(String[] args) {
			
			String f = "f1.csv";
			BufferedReader br = null;
			
			try {
				br = new BufferedReader(new FileReader(f));
				
				Map<String, Integer> map = new HashMap<>();
				String line = br.readLine();
				while (line != null) {
					String[] words = line.split(",");
					for (String word : words) {
						map.put(word, map.getOrDefault(word, 0) + 1);
					}
					line = br.readLine();
				}
				
				PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
				for (String word : map.keySet()) {
					pq.offer(word);
				}
				return pq.peek();		
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("file not fount");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("IO problem");
			} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}	
		}
		
//		##tr替换， 
//		tr -c '[:alnum:]' '[\n*]' < test.txt | sort | uniq -c | sort -nr | head  -10
//		## e指令模式, 先把每个单词都换成一行， \n是每一行的意思，uniq -c进行计数
//		sed -e 's/\s/\n/g' < test.txt | sort | uniq -c | sort -nr | head  -10
}
