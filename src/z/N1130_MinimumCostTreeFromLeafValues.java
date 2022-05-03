package z;

public class N1130_MinimumCostTreeFromLeafValues {
	public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack();
        st.push(Integer.MAX_VALUE);
        int mct = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] >= st.peek()) {
                mct += st.pop() * Math.min(st.peek(), arr[i]);
            }
            st.push(arr[i]);
        }
        while (st.size() > 2) {
            mct += st.pop() * st.peek();
        }
        return mct;
    }
}
