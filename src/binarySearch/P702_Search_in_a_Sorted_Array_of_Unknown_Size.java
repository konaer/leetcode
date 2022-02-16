package binarySearch;

public class P702_Search_in_a_Sorted_Array_of_Unknown_Size {
	
	public int search(ArrayReader reader, int target) {
		int left = 0;
		int right = 1;
		
		while (reader.get(right) < target) {
			left = right;
			right *= 2;
		}
		
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (reader.get(mid) < target) {
				left = mid + 1;
			} else if (reader.get(mid) >= target) {
				right = mid;
			} 
		}	
		return reader.get(left) == target? left : -1;
	}	
}
