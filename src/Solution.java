

import java.util.*;


class Solution {
	
	private static void p(int num) throws Exception {
		try {
			System.out.println(num);
		} finally {
			System.out.println("finished");
		}
	}
    
    public static void main(String[] args) throws Exception{
    	Scanner s = new Scanner(System.in);
    	int num = s.nextInt();
    	p(num);
    	s.close();
	}

	
}
