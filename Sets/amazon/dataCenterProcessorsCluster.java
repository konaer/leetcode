package z;

import java.util.PriorityQueue;

//https://www.1point3acres.com/bbs/thread-841736-1-1.html

public class dataCenterProcessorsCluster {
	public static int find(int[] processingPower, int[] bootingPower, int maxPower){
        if(processingPower == null || bootingPower == null 
            || processingPower.length == 0 || processingPower.length != bootingPower.length){
                return 0;
        }

        PriorityQueue<Integer> maxBootingPower = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        int maxLength = 0;
        int currentLength = 1;

        int start = 0;
        int end = 0;
        
        int currentSumProcessingPower = processingPower[0];
        maxBootingPower.add(bootingPower[0]);
        while(end < processingPower.length){
            int currentBootingPower = maxBootingPower.peek();
            int currentPower = currentBootingPower + currentSumProcessingPower * currentLength;

            if(currentPower <= maxPower){
                maxLength = currentLength;
                end++;
                currentLength++;
            }
            else{
                currentSumProcessingPower -= processingPower[start];
                maxBootingPower.remove(bootingPower[start]);
                start++;
                end++;
            }

            if(end < processingPower.length){
                maxBootingPower.add(bootingPower[end]);
                currentSumProcessingPower += processingPower[end];
            }
        }

        return maxLength;
    }
	
	public static void main(String[] args){
        int[] processingPower = new int[]{1, 2, 3, 4};
        int[] bootingPower = new int[]{1, 2, 3, 4};
        int maxPower = 10;

        System.out.println(find(processingPower, bootingPower, maxPower));   // output should be 2
    }
}
