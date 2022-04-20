package z;

import java.util.Comparator;
import java.util.*;

//http://webcache.googleusercontent.com/search?q=cache:https://leetcode.com/discuss/interview-question/1488397/Amazon-OA-or-SDE-US&rlz=1C1CHBF_enUS975US975&strip=1&vwsrc=0

public class Insert {
	 public static class Item implements Comparable<Item>{

	        /* attributes of an item */
	        private int price;
	        private String name;

	        // constructor 
	        public Item(int price, String name)
	        {
	            this.price = price;
	            this.name = name; 
	        }

	        // default constructor
	        public Item(){};

	        // get price name 
	        public int getPrice()
	        {
	            return this.price;
	        }

	        // get item name
	        public String getName()
	        {
	            return this.name;
	        }

	        @Override 
	        public int compareTo(Item o) {
	            return Comparator.comparingInt(Item::getPrice) // sort item based on price first
	                    .thenComparing(Item::getName) // then sort by name 
	                    .compare(this, o);
	        }
	    }
	    
	    /*
	        Complete the 'getItems' function below.
	        The function is expected to return a STRING_ARRAY.
	        The function accepts 2D_STRING_ARRAY entries as parameter.
	    */
	    public static List<String> getItems(List<List<String>> entries) 
	    {
	        // Write your code here

	        /* variables */
	        int size = entries.size(); 
	        int currentView = 0; // used to keep track of how many views have been called
	        int j = 0;
	        List<String> result = new ArrayList<>();  
	        PriorityQueue<Item> pq = new PriorityQueue<>();  // made to be as a min heap
	        ArrayList<Item> itemsPolled = new ArrayList<>(); // to keep track of items polled from priority queue
	        

	        /* Traverse through entries */
	        for(int i = 0; i < size; i++)
	        {
	            String s = entries.get(i).get(0); // grab the command 

	            // check if current entry is an INSERT command
	            if(s.equals("INSERT"))
	            {
	                String curItem = entries.get(i).get(1); // grab item name
	                int curPrice = Integer.parseInt(entries.get(i).get(2)); // grab item price

	                // create Item object
	                Item newItem = new Item(curPrice, curItem);
	                pq.add(newItem); // add the new item to priority queue
	            }           
	            
	            // else the command is VIEW
	            else
	            {
	                j = 0; // reset j to 0
	                currentView++; // increment the amount of view calls
	                String resultString = "";

	                // poll the priority queue to the amount of currentView calls there is currently
	                while(j < currentView)
	                {
	                    Item currItem = pq.poll();
	                    itemsPolled.add(currItem); // add item polled to arrayList, so you can add it back to the heap
	                    resultString = currItem.getName(); // this is the item the customer sees
	                    j++;
	                }                

	                // add back the polled items into the priority queue
	                for(int l = 0; l < itemsPolled.size(); l++)
	                {
	                    pq.add(itemsPolled.get(l));
	                }

	                itemsPolled.clear(); // clear the arrayList for next iteration 
	                result.add(resultString);  // add the item the customer sees to the result
	            }
	        } 
	        return result;
	    }
}
