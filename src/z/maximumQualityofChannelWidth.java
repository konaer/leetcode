package z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class maximumQualityofChannelWidth {
	public static long maximumQuality(List<Integer> packets, int channels) {
	    // Write your code here
	        int n = packets.size();
	        
	        double answer = 0;
	        if(n == channels) {
	            for(int i = 0;i<n;i++) {
	                answer += packets.get(i);
	            }
	            return (long)answer;
	        }
	        Collections.sort(packets);
	        
	        for(int i = n - channels+1; i < n; i++) {
	            answer += packets.get(i);
	        }
	        
	        n = n-channels;
	        if(n % 2 == 0) {
	            // odd
	            answer += packets.get(n/2);
	        }
	        else {
	            //even
	            double value = packets.get(n/2) + packets.get((n/2) + 1);
	            answer += value/2;
	        }
	        return (long)Math.ceil(answer);
	    }
	
	public static void main(String[] args) {
		List<Integer> packets = new ArrayList<>(List.of(1,2,3,4,5));

		int channels = 2;
		System.out.println(maximumQuality(packets, channels));
	}
}



//You are given a list of packets of varying sizes and there are n channels.
//
//Each of the n channel must have a single packet
//Each packet can only be on a single channel
//The quality of a channel is described as the median of the packet sizes on that channel. The total quality is defined as sum of the quality of all channels (round to integer in case of float). Given the packets []int32 and channels int32 find the maximum quality.
//
//Example 1:
//
//packets := []int32{1, 2, 3, 4, 5}
//channels := 2
//
//// Explaination: If packet {1, 2, 3, 4} is sent to channel 1, the median of that channel would be 2.5.
////               If packet {5} is sent to channel 2 its median would be 5. 
////               Total quality would be 2.5 + 5 = 7.5 ~ 8
//answer := 8
//Example 2:
//
//packets := []int32{5, 2, 2, 1, 5, 3}
//channels := 2
//
//// Explaination: Channel 1: {2, 2, 1, 3} (median: 2)
////               Channel 2: {5, 5}       (median: 5)
////               Total Quality : 2 + 5 = 7
//
//// Explaination 2: Channel 1: {5, 2, 2, 1, 3} (median: 2)
////                 Channel 2: {5}             (median: 5)
////                 Total Quality : 2 + 5 = 7
//answer := 7
