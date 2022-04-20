package z;

public class N1656_DesignOrderedStream {
	private int ptr = 1;
    private final String[] arr;

    public OrderedStream(int n) {
        arr = new String[n + 1];
    }
    
    public List<String> insert(int idKey, String value) {
        arr[idKey] = value;
        List<String> res = new ArrayList<>();
        while (ptr < arr.length && arr[ptr] != null) {
            res.add(arr[ptr]);
            ptr++;
        }
        return res;
    }
}
