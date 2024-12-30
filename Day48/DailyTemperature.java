package Day48;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];

        Deque<Integer> st = new LinkedList<>();
        st.push(0); // Default to put the first element.
        for (int i = 1; i < temperatures.length; i++) {
                while (! st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    result[st.peek()] = i - st.peek();
                    st.pop();
                }
                st.push(i);
            }
        return result;
    }
}
